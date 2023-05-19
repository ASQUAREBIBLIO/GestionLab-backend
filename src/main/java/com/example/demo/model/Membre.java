package com.example.demo.model;

import java.util.List;

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
    
    private String nom;
    private String prenom;
    private String email;
    private boolean isDirector;
    
    @ManyToMany 
    @JoinTable (
    		name = "DotationProjet",
    		joinColumns = @JoinColumn(name = "id"),
    		inverseJoinColumns = @JoinColumn(name ="idProjet")
    		)
    private List<Projet> projets;
    
    @ManyToOne
    private Laboratoire laboratoire;
    
	//member has many ucaRech
    @ManyToMany(mappedBy = "membres")
    private List<UcaRech> ucaRechs;
    
    @OneToMany(mappedBy = "membre")
    private List<ExpressionBesoin> expressionsBesoin;

}
