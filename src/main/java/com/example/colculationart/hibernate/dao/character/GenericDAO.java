package com.example.colculationart.hibernate.dao.character;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Общий DAO для базовых операций с сущностями.
 *
 * @param <T> Тип сущности, с которой работает DAO.
 */
public class GenericDAO<T> {

    private static final Logger logger = LoggerFactory.getLogger(GenericDAO.class);
    private static final SessionFactory sessionFactory;

    static {
        try {
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml")
                    .build();
            Metadata metadata = new MetadataSources(registry)
                    .getMetadataBuilder()
                    .build();
            sessionFactory = metadata.getSessionFactoryBuilder().build();
        } catch (Exception ex) {
            logger.error("Initial SessionFactory creation failed", ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    private final Class<T> entityClass;

    /**
     * Конструктор для инициализации DAO с указанием класса сущности.
     *
     * @param entityClass Класс сущности.
     */
    public GenericDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    /**
     * Добавляет сущность в базу данных.
     *
     * @param entity Сущность для добавления.
     */
    public void addEntity(T entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.persist(entity);
            tx.commit();
            logger.info("Добавлена сущность: {}", entity);
        } catch (Exception e) {
            logger.error("Ошибка при добавлении сущности", e);
        }
    }

    /**
     * Возвращает сущность по идентификатору.
     *
     * @param id Идентификатор сущности.
     * @return Сущность с указанным идентификатором или null, если сущность не найдена.
     */
    public T getEntity(Long id) {
        Session session = sessionFactory.openSession();
        T entity = null;
        try {
            entity = session.get(entityClass, id);
        } catch (Exception e) {
            logger.error("Ошибка при получении сущности по id", e);
        } finally {
            session.close();
        }
        return entity;
    }

    /**
     * Возвращает список всех сущностей данного типа из базы данных.
     *
     * @return Список всех сущностей данного типа или пустой список, если сущностей нет.
     */
    public List<T> getAllEntities() {
        Session session = sessionFactory.openSession();
        List<T> entities = null;
        try {
            entities = session.createQuery("from " + entityClass.getName(), entityClass).list();
        } catch (Exception e) {
            logger.error("Ошибка при получении всех сущностей", e);
        } finally {
            session.close();
        }
        return entities;
    }

    /**
     * Обновляет существующую сущность в базе данных.
     *
     * @param entity Сущность для обновления.
     */
    public void updateEntity(T entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.merge(entity);
            tx.commit();
            logger.info("Обновлена сущность: {}", entity);
        } catch (Exception e) {
            logger.error("Ошибка при обновлении сущности", e);
        }
    }

    /**
     * Удаляет сущность из базы данных по идентификатору.
     *
     * @param id Идентификатор сущности для удаления.
     */
    public void deleteEntity(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            T entity = session.get(entityClass, id);
            if (entity != null) {
                session.remove(entity);
                logger.info("Удалена сущность с id: {}", id);
            }
            tx.commit();
        } catch (Exception e) {
            logger.error("Ошибка при удалении сущности", e);
        }
    }

    /**
     * Проверяет существование сущности по имени.
     *
     * @param name Имя сущности для проверки.
     * @return true, если сущность с указанным именем существует, false в противном случае.
     */
    public boolean existsByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Long> query = builder.createQuery(Long.class);
            Root<T> root = query.from(entityClass);

            query.select(builder.count(root))
                    .where(builder.equal(root.get("name"), name));

            Long count = session.createQuery(query).getSingleResult();
            return count != null && count > 0;
        } catch (Exception e) {
            logger.error("Ошибка при проверке существования сущности по имени", e);
            return false;
        }
    }

    /**
     * Возвращает сущность по имени.
     *
     * @param name Имя сущности.
     * @return Сущность с указанным именем или null, если сущность не найдена.
     */
    public T getByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<T> query = builder.createQuery(entityClass);
            Root<T> root = query.from(entityClass);

            query.select(root)
                    .where(builder.equal(root.get("name"), name));

            return session.createQuery(query).getSingleResult();
        } catch (Exception e) {
            logger.error("Ошибка при получении сущности по имени", e);
            return null;
        }
    }
}
