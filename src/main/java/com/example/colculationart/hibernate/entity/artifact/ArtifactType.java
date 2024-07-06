package com.example.colculationart.hibernate.entity.artifact;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ArtifactType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "artifact_set_id", nullable = false)
    private ArtifactSet artifactSet;

    private String flower;
    private String plume;
    private String sands;
    private String goblet;
    private String circlet;
}
