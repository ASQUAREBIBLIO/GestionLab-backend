package com.example.demo.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("marche")
public class ResponsableMarche extends Responsable {
    //  les attributs spécifiques au responsable des marchés
    
    // Constructeurs, getters et setters
}
