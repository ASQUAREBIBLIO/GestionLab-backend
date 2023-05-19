package com.example.demo.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Laboratoire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String nomLabo;
    
    @ManyToOne
    private Etablissement etablissement;
    
    @OneToMany(mappedBy="laboratoire")
	private Set<Membre> membres;
    // Constructeurs, getters et setters

	public Laboratoire() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomLabo() {
		return nomLabo;
	}

	public void setNomLabo(String nomLabo) {
		this.nomLabo = nomLabo;
	}

	public Etablissement getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(Etablissement etablissement) {
		this.etablissement = etablissement;
	}
    
        
}
