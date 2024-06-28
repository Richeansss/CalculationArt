package com.example.colculationart.hibernate.dao;

import com.example.colculationart.hibernate.dao.onefieldtable.ElementDAO;
import com.example.colculationart.hibernate.dao.onefieldtable.QualityDAO;
import com.example.colculationart.hibernate.dao.onefieldtable.RegionDAO;
import com.example.colculationart.hibernate.dao.onefieldtable.TypeOfWeaponDAO;
import com.example.colculationart.hibernate.entity.Element;
import com.example.colculationart.hibernate.entity.Quality;
import com.example.colculationart.hibernate.entity.Region;
import com.example.colculationart.hibernate.entity.TypeOfWeapon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * Утилитарный класс для тестирования операций DAO.
 */
public class TestOfDAO {

    private static final Logger logger = LoggerFactory.getLogger(TestOfDAO.class);

    /**
     * Основной метод для тестирования операций DAO.
     *
     * @param args Аргументы командной строки (не используются).
     */
    public static void main(String[] args) {
        createElements();
        createTypeOfWeapons();
        createQuality();
        createRegion();
    }

    /**
     * Создает элементы, если они еще не существуют.
     */
    public static void createElements() {
        ElementDAO elementDAO = new ElementDAO();
        List<String> elementNames = Arrays.asList("Electro", "Geo", "Cryo", "Pyro", "Anemo", "Dendro", "Hydro", "None");

        for (String name : elementNames) {
            if (!elementDAO.existsByName(name)) {
                Element element = new Element();
                element.setName(name);
                elementDAO.addEntity(element);
                logger.info("Добавлен элемент с именем: {}", name);
            } else {
                logger.info("Элемент с именем {} уже существует.", name);
            }
        }
    }

    /**
     * Создает типы оружия, если они еще не существуют.
     */
    public static void createTypeOfWeapons() {
        TypeOfWeaponDAO typeOfWeaponDAO = new TypeOfWeaponDAO();
        List<String> typeOfWeaponNames = Arrays.asList("Sword", "Claymore", "Polearm", "Catalyst", "Bow");

        for (String name : typeOfWeaponNames) {
            if (!typeOfWeaponDAO.existsByName(name)) {
                TypeOfWeapon typeOfWeapon = new TypeOfWeapon();
                typeOfWeapon.setName(name);
                typeOfWeaponDAO.addEntity(typeOfWeapon);
                logger.info("Добавлен тип оружия с именем: {}", name);
            } else {
                logger.info("Тип оружия с именем {} уже существует.", name);
            }
        }
    }

    /**
     * Создает качества, если они еще не существуют.
     */
    public static void createQuality() {
        QualityDAO qualityDAO = new QualityDAO();
        List<String> qualityNames = Arrays.asList("1 stars", "2 stars", "3 stars", "4 stars", "5 stars");

        for (String name : qualityNames) {
            if (!qualityDAO.existsByName(name)) {
                Quality quality = new Quality();
                quality.setName(name);
                qualityDAO.addEntity(quality);
                logger.info("Добавлено качество с именем: {}", name);
            } else {
                logger.info("Качество с именем {} уже существует.", name);
            }
        }
    }

    /**
     * Создает регионы, если они еще не существуют.
     */
    public static void createRegion() {
        RegionDAO regionDAO = new RegionDAO();
        List<String> regionNames = Arrays.asList("Mondstadt", "Liyue", "Inazuma", "Sumeru", "Fontaine", "Natlan","Snezhnaya", "None");

        for (String name : regionNames) {
            if (!regionDAO.existsByName(name)) {
                Region region = new Region();
                region.setName(name);
                regionDAO.addEntity(region);
                logger.info("Добавлен регион с именем: {}", name);
            } else {
                logger.info("Регион с именем {} уже существует.", name);
            }
        }
    }
}
