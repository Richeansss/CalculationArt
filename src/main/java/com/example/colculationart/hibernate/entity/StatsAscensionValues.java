package com.example.colculationart.hibernate.entity;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "statsascensionvalues")
public class StatsAscensionValues {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ascensionHp")
    private double ascensionHp;

    @Column(name = "ascensionAtk")
    private double ascensionAtk;

    @Column(name = "ascensionDef")
    private double ascensionDef;
}
