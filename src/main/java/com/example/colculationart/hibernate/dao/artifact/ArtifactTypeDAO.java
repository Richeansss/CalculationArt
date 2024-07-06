package com.example.colculationart.hibernate.dao.artifact;

import com.example.colculationart.hibernate.dao.character.GenericDAO;
import com.example.colculationart.hibernate.entity.artifact.ArtifactType;

public class ArtifactTypeDAO extends GenericDAO<ArtifactType> {
    public ArtifactTypeDAO() {super(ArtifactType.class);}
}
