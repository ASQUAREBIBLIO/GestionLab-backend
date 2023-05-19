package com.example.demo.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
public class ExpressionBesoin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private double montantApprox;
    private Date dateDem;
    private Date dateEffet;
    private double montantEffet;
    private boolean isValid;
    
    @ManyToOne
    private Membre membre;
    
    @ManyToOne
    private Responsable responsable;
    
    @ManyToOne
    private TypeBesoin typeBesoin;
}
