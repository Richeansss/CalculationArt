package com.example.colculationart.hibernate.dao.onefieldtable;

import com.example.colculationart.hibernate.entity.CharacterStats;

/**
 * DAO для выполнения CRUD операций с сущностью CharacterStats.
 */
public class CharacterStatsDAO extends GenericDAO<CharacterStats> {
    /**
     * Конструктор для инициализации DAO с указанием класса сущности CharacterStats.
     */
    public CharacterStatsDAO() {
        super(CharacterStats.class);
    }
}
