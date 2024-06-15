package com.example.colculationart.hibernate;

import com.example.colculationart.hibernate.entity.CharacterStats;
import com.example.colculationart.hibernate.entity.StatsAscensionValues;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;

public class Teststart {

    public static void main(String[] args) {
        // Создаем конфигурацию Hibernate
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();
        MetadataSources sources = new MetadataSources(registry);

        // Явно добавляем классы сущностей
        sources.addAnnotatedClass(CharacterStats.class);
        sources.addAnnotatedClass(StatsAscensionValues.class);

        // Используем сессионную фабрику из HibernateUtil
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        // Добавляем Ascension Values
        if (checkAscensionValuesExists(sessionFactory, 4228.035, 80.28111, 280.098)) {
            System.out.println("Предупреждение: Запись с такими же характеристиками уже существует в базе данных.");
        } else {
            addAscensionValues(sessionFactory, 4228.035, 80.28111, 280.098);
        }

        // Добавляем Character
        addCharacter(sessionFactory, "Albedo", 100, 50, 30, 80, 20, 2L);

        // Закрываем фабрику сессий
        sessionFactory.close();
    }

    public static void addAscensionValues(SessionFactory sessionFactory, double ascensionHp, double ascensionAtk, double ascensionDef) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            // Create and persist StatsAscensionValues
            StatsAscensionValues ascensionValues = new StatsAscensionValues();
            ascensionValues.setAscensionHp(ascensionHp);
            ascensionValues.setAscensionAtk(ascensionAtk);
            ascensionValues.setAscensionDef(ascensionDef);

            session.persist(ascensionValues);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void addCharacter(SessionFactory sessionFactory, String name, double baseHp, double baseAtk, double baseDef, double baseEM, double baseER, Long ascensionValuesId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            // Find the corresponding StatsAscensionValues by ID
            StatsAscensionValues ascensionValues = session.get(StatsAscensionValues.class, ascensionValuesId);

            // Create and persist CharacterStats
            CharacterStats character = new CharacterStats();
            character.setName(name);
            character.setBaseHp(baseHp);
            character.setBaseAtk(baseAtk);
            character.setBaseDef(baseDef);
            character.setBaseEM(baseEM);
            character.setBaseER(baseER);

            session.persist(character);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static boolean checkAscensionValuesExists(SessionFactory sessionFactory, double hp, double atk, double def) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<StatsAscensionValues> criteriaQuery = builder.createQuery(StatsAscensionValues.class);
            Root<StatsAscensionValues> root = criteriaQuery.from(StatsAscensionValues.class);
            criteriaQuery.select(root)
                    .where(builder.equal(root.get("ascensionHp"), hp),
                            builder.equal(root.get("ascensionAtk"), atk),
                            builder.equal(root.get("ascensionDef"), def));

            Query<StatsAscensionValues> query = session.createQuery(criteriaQuery);

            List<StatsAscensionValues> resultList = query.getResultList();

            if (resultList.isEmpty()) {
                // Запись не существует
                System.out.println("Запись не существует");
                return false;
            } else if (resultList.size() == 1) {
                // Запись существует и является уникальной
                System.out.println("Запись уникальна");
                return true;
            } else {
                // Запись не уникальна
                System.out.println("Запись не уникальна, количество записей: " + resultList.size());
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
