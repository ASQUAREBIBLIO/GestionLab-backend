package com.example.demo.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ResponsableFinance")
public class ResponsableFinance extends Responsable {
    
}
