package com.example.demo.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

//import com.fasterxml.jackson.annotation.JsonProperty;

//import jakarta.persistence.CascadeType;
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
    
    // @OneToMany(mappedBy = "membre")
    // private Set<MembreUcaRech> membreUcaRechs = new HashSet<>();
    
    @OneToMany(mappedBy = "membre")
    private List<ExpressionBesoin> expressionsBesoin;

}
