package com.example.colculationart.hibernate.tables;

import com.example.colculationart.hibernate.dao.artifact.ArtifactRarityDAO;
import com.example.colculationart.hibernate.entity.artifact.ArtifactRarity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * Класс для создания записей в таблице ArtifactRarity.
 */
public class CreateArtifactTable {

    /**
     * Логгер для записи логов.
     */
    private static final Logger logger = LoggerFactory.getLogger(CreateCharacterTable.class);

    /**
     * Главный метод, запускающий создание записей в таблице ArtifactRarity.
     *
     * @param args аргументы командной строки (не используются).
     */
    public static void main(String[] args) {
        createArtifactRarity();
    }

    /**
     * Создает записи в таблице ArtifactRarity для каждого уровня, если запись с таким уровнем ещё не существует. (1, 2, 3, 4, 5)
     */
    public static void createArtifactRarity() {
        ArtifactRarityDAO artifactRarityDAO = new ArtifactRarityDAO();

        // Список уровней редкости артефактов
        List<Integer> artifactRarityLevels = Arrays.asList(1, 2, 3, 4, 5);

        // Проверка существования и добавление новых записей
        for (Integer level : artifactRarityLevels) {
            if (!artifactRarityDAO.existsByLevel(level)) {
                ArtifactRarity rarity = new ArtifactRarity();
                rarity.setLevel(level);
                artifactRarityDAO.addEntity(rarity);
                logger.info("Добавлено качество с именем: {}", level);
            } else {
                logger.info("Качество с именем {} уже существует.", level);
            }
        }
    }
}
