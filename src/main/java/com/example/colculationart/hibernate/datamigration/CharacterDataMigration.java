package com.example.colculationart.hibernate.datamigration;

import com.example.colculationart.hibernate.dao.character.*;
import com.example.colculationart.hibernate.entity.*;
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

/**
 * Класс для выполнения миграции данных из CSV файла в базу данных.
 */
public class CharacterDataMigration {

    private static final Logger logger = LoggerFactory.getLogger(CharacterDataMigration.class);

    public static void main(String[] args) {

        try (SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            CharacterStatsDAO characterStatsDAO = new CharacterStatsDAO();
            ElementDAO elementDAO = new ElementDAO();
            QualityDAO qualityDAO = new QualityDAO();
            RegionDAO regionDAO = new RegionDAO();
            TypeOfWeaponDAO typeOfWeaponDAO = new TypeOfWeaponDAO();

            // Получение всех существующих имен CharacterStats
            Set<String> characterStatsNames = getExistingCharacterNames(characterStatsDAO);

            // Чтение данных из CSV
            try (Reader reader = new FileReader("src/main/java/com/example/colculationart/hibernate/datamigration/Character.csv");
                 CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {

                for (CSVRecord csvRecord : csvParser) {
                    String name = csvRecord.get("name");
                    double baseHP = Double.parseDouble(csvRecord.get("baseHP").replace(",", ""));
                    double baseAtk = Double.parseDouble(csvRecord.get("baseAtk").replace(",", ""));
                    double baseDef = Double.parseDouble(csvRecord.get("baseDef").replace(",", ""));
                    String qualityName = csvRecord.get("quality");
                    String elementName = csvRecord.get("element");
                    String weaponName = csvRecord.get("weapon");
                    String regionName = csvRecord.get("region");

                    // Проверка существования записи
                    if (characterStatsNames.contains(name)) {
                        logger.info("Запись с именем {} уже существует, пропуск.", name);
                        continue;
                    }

                    // Найти объекты
                    Element element = elementDAO.getByName(elementName);
                    Quality quality = qualityDAO.getByName(qualityName);
                    Region region = regionDAO.getByName(regionName);
                    TypeOfWeapon typeOfWeapon = typeOfWeaponDAO.getByName(weaponName);

                    // Пропустить запись, если хотя бы одно из значений не найдено
                    if (element == null || quality == null || region == null || typeOfWeapon == null) {
                        logger.warn("Пропуск записи {} из-за отсутствия ссылок.", name);
                        continue;
                    }

                    // Создать и сохранить CharacterStats
                    CharacterStats characterStats = new CharacterStats();
                    characterStats.setName(name);
                    characterStats.setBaseHp(baseHP);
                    characterStats.setBaseAtk(baseAtk);
                    characterStats.setBaseDef(baseDef);
                    characterStats.setElement(element);
                    characterStats.setQuality(quality);
                    characterStats.setRegion(region);
                    characterStats.setTypeOfWeapon(typeOfWeapon);

                    characterStatsDAO.addEntity(characterStats);
                    logger.info("Добавлена запись: {}", name);
                }
            } catch (Exception e) {
                logger.error("Ошибка при чтении CSV файла", e);
            }

            session.getTransaction().commit();
        }
    }

    /**
     * Получает существующие имена всех сущностей CharacterStats и возвращает их в виде HashSet.
     *
     * @param characterStatsDAO DAO для работы с CharacterStats.
     * @return Набор имен всех сущностей CharacterStats.
     */
    private static Set<String> getExistingCharacterNames(CharacterStatsDAO characterStatsDAO) {
        List<CharacterStats> allCharacterStats = characterStatsDAO.getAllEntities();
        Set<String> characterStatsNames = new HashSet<>();
        for (CharacterStats characterStats : allCharacterStats) {
            characterStatsNames.add(characterStats.getName());
        }
        return characterStatsNames;
    }
}
