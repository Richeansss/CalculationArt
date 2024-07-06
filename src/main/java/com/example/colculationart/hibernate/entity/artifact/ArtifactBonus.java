package com.example.colculationart.hibernate.entity.artifact;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
public class ArtifactBonus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bonus_type")
    private String bonusType;

    @Column(name = "bonus_description", length = 1000) // Увеличьте длину до 1000 символов
    private String bonusDescription;

    @ManyToMany(mappedBy = "bonuses")
    private Set<ArtifactSet> artifactSets;
}
