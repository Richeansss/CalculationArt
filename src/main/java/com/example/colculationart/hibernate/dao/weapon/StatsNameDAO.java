package com.example.colculationart.hibernate.dao.weapon;

import com.example.colculationart.hibernate.dao.character.GenericDAO;
import com.example.colculationart.hibernate.entity.StatsName;

public class StatsNameDAO extends GenericDAO<StatsName> {
    public StatsNameDAO() {super(StatsName.class);}
}
