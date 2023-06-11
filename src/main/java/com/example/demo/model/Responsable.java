package com.example.demo.model;

import java.util.List;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
@Setter @Getter @AllArgsConstructor @NoArgsConstructor
//@Inheritance(strategy = InheritanceType.JOINED)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "responsable_type", discriminatorType = DiscriminatorType.STRING)
public class Responsable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nom;
    private String prenom;
    private String email;
    private String password;

    
    @OneToMany(mappedBy = "responsable")
    private List<ExpressionBesoin> expressionsBesoin;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;
}
