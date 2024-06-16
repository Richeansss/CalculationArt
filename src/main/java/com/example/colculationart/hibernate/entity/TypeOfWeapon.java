package com.example.colculationart.hibernate.entity;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Getter
@Setter
@Entity
public class TypeOfWeapon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
}
