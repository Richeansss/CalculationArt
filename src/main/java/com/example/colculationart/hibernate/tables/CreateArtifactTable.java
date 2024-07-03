package com.example.colculationart.hibernate.tables;

import com.example.colculationart.hibernate.dao.artifact.ArtifactRarityDAO;
import com.example.colculationart.hibernate.entity.ArtifactRarity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class CreateArtifactTable {

    private static final Logger logger = LoggerFactory.getLogger(CreateCharacterTable.class);


    public static void main(String[] args) {
        createArtifactRarity();
    }

    public static void createArtifactRarity() {
        ArtifactRarityDAO artifactRarityDAO = new ArtifactRarityDAO();

        List<Integer> artifactRarityLevels = Arrays.asList(1, 2, 3, 4, 5);

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
