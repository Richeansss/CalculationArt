package com.example.colculationart.hibernate.entity.artifact;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
public class ArtifactRarity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int level;  // 1, 2, 3, 4, 5

    @ManyToMany(mappedBy = "allowedRarities")
    private Set<ArtifactSet> artifactSets;
}
