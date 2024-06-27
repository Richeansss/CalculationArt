package com.example.colculationart.hibernate.dao;

import com.example.colculationart.hibernate.dao.onefieldtable.*;
import com.example.colculationart.hibernate.entity.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.FileReader;
import java.io.Reader;

public class DataMigration {
    public static void main(String[] args) {

        try (SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            ElementDAO elementDAO = new ElementDAO();
            QualityDAO qualityDAO = new QualityDAO();
            RegionDAO regionDAO = new RegionDAO();
            TypeOfWeaponDAO typeOfWeaponDAO = new TypeOfWeaponDAO();
            CharacterStatsDAO characterStatsDAO = new CharacterStatsDAO();

            // Чтение данных из CSV
            try (Reader reader = new FileReader("src/main/java/com/example/colculationart/Character.csv");
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

                    // Найти объекты
                    Element element = elementDAO.getByName(elementName);
                    Quality quality = qualityDAO.getByName(qualityName);
                    Region region = regionDAO.getByName(regionName);
                    TypeOfWeapon typeOfWeapon = typeOfWeaponDAO.getByName(weaponName);

                    // Пропустить запись, если хотя бы одно из значений не найдено
                    if (element == null || quality == null || region == null || typeOfWeapon == null) {
                        System.out.println("Skipping " + name + " due to missing references.");
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
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            session.getTransaction().commit();
        }
    }
}
