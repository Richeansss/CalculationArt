package com.example.colculationart.hibernate.dao;

import com.example.colculationart.hibernate.entity.TypeOfWeapon;
public class TestOfDAO {
    public static void main(String[] args) {
        TypeOfWeaponDAO dao = new TypeOfWeaponDAO();

        // Create new TypeOfWeapon
        TypeOfWeapon weapon = new TypeOfWeapon();
        weapon.setName("Sword");
        dao.addTypeOfWeapon(weapon);

        // Read TypeOfWeapon
        TypeOfWeapon retrievedWeapon = dao.getTypeOfWeapon(weapon.getId());
        System.out.println("Retrieved Weapon: " + retrievedWeapon.getName());

        // Update TypeOfWeapon
        retrievedWeapon.setName("Longsword");
        dao.updateTypeOfWeapon(retrievedWeapon);

    }
}
