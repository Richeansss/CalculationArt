package com.example.colculationart.hibernate.dao;

import com.example.colculationart.hibernate.entity.Quality;

/**
 * DAO (Data Access Object) класс для операций с сущностью {@link Quality}.
 * Этот класс наследуется от {@link GenericDAO} и предоставляет дополнительные возможности для работы с сущностями типа Quality.
 */
public class QualityDAO extends GenericDAO<Quality> {

    /**
     * Конструктор для создания нового экземпляра QualityDAO.
     * Инициализирует {@link GenericDAO} с классом сущности {@link Quality}.
     */
    public QualityDAO() {
        super(Quality.class);
    }
}
