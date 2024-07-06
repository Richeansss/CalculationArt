package com.example.colculationart.hibernate.datamigration;

import com.example.colculationart.hibernate.dao.artifact.ArtifactBonusDAO;
import com.example.colculationart.hibernate.dao.artifact.ArtifactRarityDAO;
import com.example.colculationart.hibernate.dao.artifact.ArtifactSetDAO;
import com.example.colculationart.hibernate.dao.artifact.ArtifactTypeDAO;
import com.example.colculationart.hibernate.entity.artifact.ArtifactBonus;
import com.example.colculationart.hibernate.entity.artifact.ArtifactRarity;
import com.example.colculationart.hibernate.entity.artifact.ArtifactSet;
import com.example.colculationart.hibernate.entity.artifact.ArtifactType;
import com.example.colculationart.hibernate.tables.CreateArtifactTable;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.io.Reader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArtifactDataMigration {
    private static final Logger logger = LoggerFactory.getLogger(ArtifactDataMigration.class);

    public static void main(String[] args) {
        try (SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            ArtifactSetDAO artifactSetDAO = new ArtifactSetDAO();
            ArtifactRarityDAO artifactRarityDAO = new ArtifactRarityDAO();
            ArtifactBonusDAO artifactBonusDAO = new ArtifactBonusDAO();
            ArtifactTypeDAO artifactTypeDAO = new ArtifactTypeDAO();


            // Чтение CSV и миграция данных
            // Получение всех ArtifactSet из базы данных
            List<ArtifactSet> existingSets = artifactSetDAO.getAllEntities();

            // Чтение CSV и миграция данных
            try (Reader reader = new FileReader("src/main/java/com/example/colculationart/hibernate/datamigration/ArtifactSet.csv");
                 CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {

                for (CSVRecord csvRecord : csvParser) {
                    String name = csvRecord.get("artifactSet");

                    // Проверка существующего ArtifactSet по имени в памяти (быстрее, чем обращение к БД)
                    if (existingSets.stream().anyMatch(set -> set.getName().equals(name))) {
                        logger.warn("ArtifactSet '{}' already exists, skipping.", name);
                        continue; // Переходим к следующей записи CSV
                    }

                    // Создание новой сущности ArtifactSet
                    ArtifactSet artifactSet = new ArtifactSet();
                    artifactSet.setName(name);

                    List<ArtifactRarity> existingRarities = artifactRarityDAO.getAllEntities();
                    if (existingRarities.isEmpty()) {
                        // Вызов метода для создания таблицы
                        CreateArtifactTable.createArtifactRarity();
                        existingRarities = artifactRarityDAO.getAllEntities(); // Повторно получить все записи после добавления
                    }
                    /// Обработка редкостей
                    Set<ArtifactRarity> rarities = new HashSet<>();
                    for (int i = 1; i <= 5; i++) {
                        final int level = i;
                        if (csvRecord.isMapped("rarity" + i) && csvRecord.get("rarity" + i).equals("1")) {
                            // Поиск существующей редкости по уровню
                            ArtifactRarity existingRarity = existingRarities.stream()
                                    .filter(r -> r.getLevel() == level)
                                    .findFirst()
                                    .orElse(null);

                            if (existingRarity != null) {
                                // Использование существующей редкости
                                rarities.add(existingRarity);
                            } else {
                                // Создание новой редкости и сохранение в базе данных
                                logger.error("Rarity {} not found", i);
                            }
                        }
                    }

                    // Установка коллекции редкостей в артефакт
                    artifactSet.setAllowedRarities(rarities);

                    // Обработка бонусов
                    Set<ArtifactBonus> bonuses = new HashSet<>();
                    for (int i = 1; i <= 4; i++) {
                        if (i == 3) {
                            continue; // Пропускаем итерацию, если i равно 3
                        }

                        String bonusDescription = csvRecord.get("bonus" + i);
                        if (bonusDescription != null && !bonusDescription.equalsIgnoreCase("null")) {
                            ArtifactBonus bonus = new ArtifactBonus();
                            bonus.setBonusType("bonus" + i);
                            bonus.setBonusDescription(bonusDescription);

                            bonuses.add(bonus);

                            // Сохранение бонуса через метод, поддерживаемый вашим DAO
                            artifactBonusDAO.addEntity(bonus); // Используйте соответствующий метод сохранения
                            logger.info("Добавлен ArtifactBonus для ArtifactSet '{}': {}", name, bonus.getBonusType());
                        }
                    }
                    artifactSet.setBonuses(bonuses);

                    // Добавление ArtifactSet только если его нет в базе данных
                    artifactSetDAO.addEntity(artifactSet);
                    logger.info("Добавлен ArtifactSet: {}", name);

                    // Добавление типов артефактов
                    ArtifactType artifactType = new ArtifactType();
                    artifactType.setArtifactSet(artifactSet);
                    artifactType.setFlower(csvRecord.get("flower"));
                    artifactType.setPlume(csvRecord.get("plume"));
                    artifactType.setSands(csvRecord.get("sands"));
                    artifactType.setGoblet(csvRecord.get("goblet"));
                    artifactType.setCirclet(csvRecord.get("circlet"));

                    // Сохранение типа артефактов
                    artifactTypeDAO.addEntity(artifactType);
                    logger.info("Добавлен ArtifactType для ArtifactSet '{}'", name);
                }
            } catch (Exception e) {
                logger.error("Ошибка при чтении CSV файла", e);
            }
            session.getTransaction().commit();
        }
    }
}
