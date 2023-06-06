package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
@AllArgsConstructor
public class Etablissement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String nom;
    private String ville;
    private String adresse;
    
    @OneToMany(mappedBy = "etablissement", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Laboratoire> laboratoires;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    public Etablissement(){
        super();
    }
}