package com.example.colculationart.hibernate.dao.character;

import com.example.colculationart.hibernate.entity.Region;

/**
 * DAO (Data Access Object) класс для операций с сущностью {@link Region}.
 * Этот класс наследуется от {@link GenericDAO} и предоставляет дополнительные возможности для работы с сущностями типа Region.
 */
public class RegionDAO extends GenericDAO<Region> {

    /**
     * Конструктор для создания нового экземпляра RegionDAO.
     * Инициализирует {@link GenericDAO} с классом сущности {@link Region}.
     */
    public RegionDAO() {
        super(Region.class);
    }
}
