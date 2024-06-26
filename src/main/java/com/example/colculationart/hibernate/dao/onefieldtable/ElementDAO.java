package com.example.colculationart.hibernate.dao.onefieldtable;

import com.example.colculationart.hibernate.entity.Element;

/**
 * DAO (Data Access Object) класс для операций с сущностью {@link Element}.
 * Этот класс наследуется от {@link GenericDAO} и предоставляет дополнительные возможности для работы с сущностями типа Element.
 */
public class ElementDAO extends GenericDAO<Element> {

    /**
     * Конструктор для создания нового экземпляра ElementDAO.
     * Инициализирует {@link GenericDAO} с классом сущности {@link Element}.
     */
    public ElementDAO() {
        super(Element.class);
    }
}
