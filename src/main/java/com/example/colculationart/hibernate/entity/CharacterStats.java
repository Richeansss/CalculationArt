package com.example.colculationart.hibernate.entity;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "characterstats")
public class CharacterStats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "baseHp")
    private double baseHp;

    @Column(name = "baseAtk")
    private double baseAtk;

    @Column(name = "baseDef")
    private double baseDef;

    @Column(name = "baseEM")
    private double baseEM;

    @Column(name = "baseER")
    private double baseER;

}
