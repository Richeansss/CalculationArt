package com.example.colculationart.hibernate.dao;


import com.example.colculationart.hibernate.entity.TypeOfWeapon;
import jakarta.transaction.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

// Hibernate конфигурация
class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Создание SessionFactory из hibernate.cfg.xml
            return new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(TypeOfWeapon.class)
                    .buildSessionFactory();
        } catch (Throwable ex) {
            // В начальной инициализации SessionFactory произошла ошибка
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Закрываем кэш и пула соединений
        getSessionFactory().close();
    }
}

// DAO класс
class TypeOfWeaponDAO {

    public void saveTypeOfWeapon(TypeOfWeapon typeOfWeapon) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Начало транзакции
            transaction = session.beginTransaction();
            // Сохранение объекта
            session.save(typeOfWeapon);
            // Завершение транзакции
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<TypeOfWeapon> getAllTypeOfWeapons() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from TypeOfWeapon", TypeOfWeapon.class).list();
        }
    }

    public TypeOfWeapon getTypeOfWeaponById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(TypeOfWeapon.class, id);
        }
    }

    public void updateTypeOfWeapon(TypeOfWeapon typeOfWeapon) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Начало транзакции
            transaction = session.beginTransaction();
            // Обновление объекта
            session.update(typeOfWeapon);
            // Завершение транзакции
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteTypeOfWeapon(Long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Начало транзакции
            transaction = session.beginTransaction();
            // Получение объекта по id
            TypeOfWeapon typeOfWeapon = session.get(TypeOfWeapon.class, id);
            if (typeOfWeapon != null) {
                // Удаление объекта
                session.delete(typeOfWeapon);
                // Завершение транзакции
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}

public class TypeOfWeaponDao {
    public static void main(String[] args) {
        TypeOfWeaponDAO typeOfWeaponDAO = new TypeOfWeaponDAO();

        // Создание нового объекта
        TypeOfWeapon newWeapon = new TypeOfWeapon();
        newWeapon.setName("Example Weapon");
        typeOfWeaponDAO.saveTypeOfWeapon(newWeapon);

        // Получение всех объектов
        typeOfWeaponDAO.getAllTypeOfWeapons().forEach(weapon -> System.out.println(weapon.getName()));

        // Обновление объекта
        TypeOfWeapon weaponToUpdate = typeOfWeaponDAO.getTypeOfWeaponById(newWeapon.getId());
        weaponToUpdate.setName("Updated Weapon");
        typeOfWeaponDAO.updateTypeOfWeapon(weaponToUpdate);

        // Удаление объекта
        typeOfWeaponDAO.deleteTypeOfWeapon(weaponToUpdate.getId());

        // Закрытие SessionFactory
        HibernateUtil.shutdown();
    }
}
