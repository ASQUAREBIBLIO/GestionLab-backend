package com.example.demo.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("financier")
public class ResponsableFinancier extends Responsable {
    // les attributs spécifiques au responsable financier
    
    // Constructeurs, getters et setters
}
