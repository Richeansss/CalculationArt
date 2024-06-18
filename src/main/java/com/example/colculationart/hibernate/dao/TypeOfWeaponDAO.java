package com.example.colculationart.hibernate.dao;

import com.example.colculationart.hibernate.entity.TypeOfWeapon;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class TypeOfWeaponDAO {

    private static final SessionFactory sessionFactory;

    static {
        try {
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml")
                    .build();
            Metadata metadata = new MetadataSources(registry)
                    .addAnnotatedClass(TypeOfWeapon.class)
                    .getMetadataBuilder()
                    .build();
            sessionFactory = metadata.getSessionFactoryBuilder().build();
        } catch (Exception ex) {
            System.err.println("Initial SessionFactory creation failed: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public void addTypeOfWeapon(TypeOfWeapon typeOfWeapon) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.persist(typeOfWeapon);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public TypeOfWeapon getTypeOfWeapon(Long id) {
        Session session = sessionFactory.openSession();
        TypeOfWeapon typeOfWeapon = null;
        try {
            typeOfWeapon = session.get(TypeOfWeapon.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return typeOfWeapon;
    }

    public List<TypeOfWeapon> getAllTypesOfWeapon() {
        Session session = sessionFactory.openSession();
        List<TypeOfWeapon> typesOfWeapon = null;
        try {
            typesOfWeapon = session.createQuery("from TypeOfWeapon", TypeOfWeapon.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return typesOfWeapon;
    }

    public void updateTypeOfWeapon(TypeOfWeapon typeOfWeapon) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.merge(typeOfWeapon);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleteTypeOfWeapon(Long id) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            TypeOfWeapon typeOfWeapon = session.get(TypeOfWeapon.class, id);
            if (typeOfWeapon != null) {
                session.delete(typeOfWeapon);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
