package com.example.colculationart.hibernate.dao.artifact;

import com.example.colculationart.hibernate.dao.character.GenericDAO;
import com.example.colculationart.hibernate.entity.ArtifactRarity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Класс DAO (Data Access Object) для управления сущностью {@link ArtifactRarity}.
 * Наследует базовый класс {@link GenericDAO}, предоставляя методы для выполнения CRUD-операций.
 */
public class ArtifactRarityDAO extends GenericDAO<ArtifactRarity> {

    /**
     * Логгер для записи логов.
     */
    private static final Logger logger = LoggerFactory.getLogger(ArtifactRarityDAO.class);

    /**
     * Фабрика сессий для взаимодействия с базой данных.
     */
    private static final SessionFactory sessionFactory;

    /**
     * Конструктор, вызывающий конструктор базового класса {@link GenericDAO} с классом сущности {@link ArtifactRarity}.
     */
    public ArtifactRarityDAO() {
        super(ArtifactRarity.class);
    }

    static {
        try {
            // Создание реестра сервисов
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml")
                    .build();

            // Создание метаданных
            Metadata metadata = new MetadataSources(registry)
                    .getMetadataBuilder()
                    .build();

            // Создание фабрики сессий
            sessionFactory = metadata.getSessionFactoryBuilder().build();
        } catch (Exception ex) {
            logger.error("Initial SessionFactory creation failed", ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Проверяет, существует ли сущность {@link ArtifactRarity} с заданным уровнем.
     *
     * @param level Уровень, по которому выполняется проверка.
     * @return {@code true}, если сущность с заданным уровнем существует, иначе {@code false}.
     */
    public boolean existsByLevel(Integer level) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Long> query = builder.createQuery(Long.class);
            Root<ArtifactRarity> root = query.from(ArtifactRarity.class);

            query.select(builder.count(root))
                    .where(builder.equal(root.get("level"), level));

            Long count = session.createQuery(query).getSingleResult();
            return count != null && count > 0;
        } catch (Exception e) {
            logger.error("Ошибка при проверке существования сущности по уровню", e);
            return false;
        }
    }
}
