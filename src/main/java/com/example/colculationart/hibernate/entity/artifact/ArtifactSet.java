package com.example.colculationart.hibernate.entity.artifact;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
public class ArtifactSet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "set_rarity",
            joinColumns = @JoinColumn(name = "set_id"),
            inverseJoinColumns = @JoinColumn(name = "rarity_id")
    )
    private Set<ArtifactRarity> allowedRarities;

    @ManyToMany
    @JoinTable(
            name = "set_bonus",
            joinColumns = @JoinColumn(name = "set_id"),
            inverseJoinColumns = @JoinColumn(name = "bonus_id")
    )
    private Set<ArtifactBonus> bonuses;
}
