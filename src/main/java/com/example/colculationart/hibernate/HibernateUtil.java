package com.example.colculationart.hibernate;

import com.example.colculationart.hibernate.entity.CharacterStats;
import com.example.colculationart.hibernate.entity.StatsAscensionValues;
import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    @Getter
    private static SessionFactory sessionFactory;

    static {
        try {
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml")
                    .build();
            MetadataSources sources = new MetadataSources(registry);
            sources.addAnnotatedClass(CharacterStats.class);
            sources.addAnnotatedClass(StatsAscensionValues.class);
            sessionFactory = sources.buildMetadata().buildSessionFactory();
        } catch (Exception ex) {
            System.err.println("Initial SessionFactory creation failed: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
}
