package com.example.colculationart.hibernate.entity.character;

import com.example.colculationart.hibernate.entity.Element;
import com.example.colculationart.hibernate.entity.Quality;
import com.example.colculationart.hibernate.entity.Region;
import com.example.colculationart.hibernate.entity.TypeOfWeapon;
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

    @ManyToOne
    @JoinColumn(name = "element_id")
    private Element element;

    @ManyToOne
    @JoinColumn(name = "quality_id")
    private Quality quality;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    @ManyToOne
    @JoinColumn(name = "type_of_weapon_id")
    private TypeOfWeapon typeOfWeapon;
}

