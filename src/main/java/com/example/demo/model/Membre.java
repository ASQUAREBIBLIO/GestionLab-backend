package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonProperty;

//import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
    private String password;
    private String email;
    private boolean isDirector;
    
    @ManyToMany 
    @JoinTable (
        name = "DotationProjet",
        joinColumns = @JoinColumn(name = "id"),
        inverseJoinColumns = @JoinColumn(name ="idProjet")
    )
    private List<Projet> projets;
    
    @ManyToOne()
    @JoinColumn(name = "laboratoire_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Laboratoire laboratoire;
    
	//member has many ucaRech
    @ManyToMany(mappedBy = "membres", fetch = FetchType.EAGER)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<UcaRech> ucaRechs = new ArrayList<>();
    
    @OneToMany(mappedBy = "membre")
    private List<ExpressionBesoin> expressionsBesoin;

}
