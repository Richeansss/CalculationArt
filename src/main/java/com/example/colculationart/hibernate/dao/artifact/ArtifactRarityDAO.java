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

public class ArtifactRarityDAO extends GenericDAO<ArtifactRarity> {
    public ArtifactRarityDAO() {
        super(ArtifactRarity.class);
    }

    private static final Logger logger = LoggerFactory.getLogger(ArtifactRarityDAO.class);
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
