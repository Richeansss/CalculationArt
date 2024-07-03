package com.example.colculationart.hibernate;

import com.example.colculationart.hibernate.dao.character.*;
import com.example.colculationart.hibernate.entity.CharacterStats;
import com.example.colculationart.hibernate.entity.Element;
import com.example.colculationart.hibernate.entity.Quality;
import com.example.colculationart.hibernate.entity.Region;
import com.example.colculationart.hibernate.entity.TypeOfWeapon;

public class TestCharacterStatTable {
    public static void main(String[] args) {
        // Создаем DAO
        ElementDAO elementDAO = new ElementDAO();
        QualityDAO qualityDAO = new QualityDAO();
        RegionDAO regionDAO = new RegionDAO();
        TypeOfWeaponDAO typeOfWeaponDAO = new TypeOfWeaponDAO();
        CharacterStatsDAO characterStatsDAO = new CharacterStatsDAO();

        // Проверяем существование и получаем элемент
        String elementName = "Geo";
        Element element;
        if (elementDAO.existsByName(elementName)) {
            element = elementDAO.getByName(elementName);
        } else {
            element = null;
            System.out.println("doesn't exits");
        }

        // Аналогично для остальных сущностей
        String qualityName = "5 star";
        Quality quality;
        if (qualityDAO.existsByName(qualityName)) {
            quality = qualityDAO.getByName(qualityName);
        } else {
            quality = null;
            System.out.println("doesn't exits");
        }

        String regionName = "Liyue";
        Region region;
        if (regionDAO.existsByName(regionName)) {
            region = regionDAO.getByName(regionName);
        } else {
            region = null;
            System.out.println("doesn't exits");
        }

        String typeOfWeaponName = "Sword";
        TypeOfWeapon typeOfWeapon;
        if (typeOfWeaponDAO.existsByName(typeOfWeaponName)) {
            typeOfWeapon = typeOfWeaponDAO.getByName(typeOfWeaponName);
        } else {
            typeOfWeapon = null;
            System.out.println("doesn't exits");
        }

        // Создаем CharacterStats и устанавливаем ссылки на сохраненные сущности
        CharacterStats characterStats = new CharacterStats();
        characterStats.setName("Hero");
        characterStats.setBaseHp(1000);
        characterStats.setBaseAtk(150);
        characterStats.setBaseDef(200);
        characterStats.setBaseEM(50);
        characterStats.setBaseER(80);
        characterStats.setElement(element);
        characterStats.setQuality(quality);
        characterStats.setRegion(region);
        characterStats.setTypeOfWeapon(typeOfWeapon);

        // Добавляем CharacterStats в базу данных
        characterStatsDAO.addEntity(characterStats);

        // Получаем CharacterStats из базы данных
        CharacterStats retrievedCharacterStats = characterStatsDAO.getEntity(characterStats.getId());
        System.out.println("Retrieved CharacterStats: " + retrievedCharacterStats.getName());

        // Обновляем CharacterStats
        retrievedCharacterStats.setBaseHp(1200);
        characterStatsDAO.updateEntity(retrievedCharacterStats);

        // Проверяем существование CharacterStats по имени
        boolean exists = characterStatsDAO.existsByName("Hero");
        System.out.println("CharacterStats exists: " + exists);

        // Удаляем CharacterStats из базы данных
//        characterStatsDAO.deleteEntity(retrievedCharacterStats.getId());
    }
}
