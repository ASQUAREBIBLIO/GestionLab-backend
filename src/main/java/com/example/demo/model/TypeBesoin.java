package com.example.demo.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class TypeBesoin {
    @Id
    private String type;
    
    @OneToMany(mappedBy = "typeBesoin")
    private List<ExpressionBesoin> expressionsBesoin;
    
    // Constructeurs, getters et setters
}
