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

@Entity
public class Membre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
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
    
    @ManyToMany(mappedBy = "membres")
    private List<UcaRech> ucaRechs;
    
    @OneToMany(mappedBy = "membre")
    private List<ExpressionBesoin> expressionsBesoin;
    
    
    // Constructeurs, getters et setters

	public Membre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isDirector() {
		return isDirector;
	}

	public void setDirector(boolean isDirector) {
		this.isDirector = isDirector;
	}

	public Laboratoire getLaboratoire() {
		return laboratoire;
	}

	public void setLaboratoire(Laboratoire laboratoire) {
		this.laboratoire = laboratoire;
	}

	public List<UcaRech> getUcaRechs() {
		return ucaRechs;
	}

	public void setUcaRechs(List<UcaRech> ucaRechs) {
		this.ucaRechs = ucaRechs;
	}

	public List<ExpressionBesoin> getExpressionsBesoin() {
		return expressionsBesoin;
	}

	public void setExpressionsBesoin(List<ExpressionBesoin> expressionsBesoin) {
		this.expressionsBesoin = expressionsBesoin;
	}
    
    
    
}
