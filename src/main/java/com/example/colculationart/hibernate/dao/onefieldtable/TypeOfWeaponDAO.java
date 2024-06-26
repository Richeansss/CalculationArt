package com.example.colculationart.hibernate.dao.onefieldtable;

import com.example.colculationart.hibernate.entity.TypeOfWeapon;

/**
 * DAO (Data Access Object) класс для операций с сущностью {@link TypeOfWeapon}.
 * Этот класс наследуется от {@link GenericDAO} и предоставляет дополнительные возможности для работы с сущностями типа TypeOfWeapon.
 */
public class TypeOfWeaponDAO extends GenericDAO<TypeOfWeapon> {

    /**
     * Конструктор для создания нового экземпляра TypeOfWeaponDAO.
     * Инициализирует {@link GenericDAO} с классом сущности {@link TypeOfWeapon}.
     */
    public TypeOfWeaponDAO() {
        super(TypeOfWeapon.class);
    }
}
