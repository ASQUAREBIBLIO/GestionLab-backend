package com.example.demo.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.InheritanceType;


@Entity
@Setter @Getter @AllArgsConstructor @NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Responsable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nom;
    private String prenom;
    private String email;
    
    @OneToMany(mappedBy = "responsable")
    private List<ExpressionBesoin> expressionsBesoin;
}
