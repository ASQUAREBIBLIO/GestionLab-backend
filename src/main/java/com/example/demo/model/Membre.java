package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
public class Membre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(length = 20)
    private String nom;

    @Column(length = 20)
    private String prenom;

    private String password;
    @Column(unique = true)
    private String email;

    private boolean isDirector;

    @OneToMany(mappedBy = "membre")
    private List<MembreUcaRech> membreUcaRechs;
    
    @ManyToMany 
    @JoinTable (
        name = "DotationProjet",
        joinColumns = @JoinColumn(name = "membreId"),
        inverseJoinColumns = @JoinColumn(name ="projetId")
    )
    private List<Projet> projets;
    
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "laboratoire_id")
    private Laboratoire laboratoire;
    
    @OneToMany(mappedBy = "membre")
    @JsonIgnore
    private List<ExpressionBesoin> expressionsBesoin;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    @JsonIgnore
    private Admin admin;

}
