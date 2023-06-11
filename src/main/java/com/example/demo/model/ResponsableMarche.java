package com.example.demo.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ResponsableMarche")
public class ResponsableMarche extends Responsable {
    
}
