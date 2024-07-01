package com.example.colculationart.hibernate.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ArtifactBonus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "set_id")
    private ArtifactSet artifactSet; // Many-to-One relationship with ArtifactSet

    @Column(name = "type")
    private String type; // You can define the type of bonus (e.g., "bonus1", "bonus2", "bonus4")

}
