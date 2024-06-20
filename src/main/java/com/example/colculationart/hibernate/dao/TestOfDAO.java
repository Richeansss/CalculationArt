package com.example.colculationart.hibernate.dao;

import com.example.colculationart.hibernate.entity.TypeOfWeapon;

public class TestOfDAO {
    public static void main(String[] args) {
        TypeOfWeaponDAO dao = new TypeOfWeaponDAO();

        // Create new TypeOfWeapon
        TypeOfWeapon weapon = new TypeOfWeapon();
        weapon.setName("Sword");
        dao.addEntity(weapon); // Использование метода из GenericDAO

        // Read TypeOfWeapon
        TypeOfWeapon retrievedWeapon = dao.getEntity(weapon.getId()); // Использование метода из GenericDAO
        System.out.println("Retrieved Weapon: " + retrievedWeapon.getName());

        // Update TypeOfWeapon
        retrievedWeapon.setName("Longsword");
        dao.updateEntity(retrievedWeapon); // Использование метода из GenericDAO

        // Проверка обновления
        TypeOfWeapon updatedWeapon = dao.getEntity(retrievedWeapon.getId());
        System.out.println("Updated Weapon: " + updatedWeapon.getName());
    }
}

