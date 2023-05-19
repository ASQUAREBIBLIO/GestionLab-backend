package com.example.demo.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProjet;
    
    private String nom;
    private Date dateDebut;
    private Date dateFin;
    private double budget;
    
    @ManyToMany(mappedBy = "projets")
    private List<Membre> membresprojets;
    
    // Constructeurs, getters et setters
	public Projet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return idProjet;
	}

	public void setId(int id) {
		this.idProjet = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public List<Membre> getMembres() {
		return membresprojets;
	}

	public void setMembres(List<Membre> membres) {
		this.membresprojets = membres;
	}
    
    
    
}
