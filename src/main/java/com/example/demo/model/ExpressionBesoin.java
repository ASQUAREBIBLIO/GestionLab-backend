package com.example.demo.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class ExpressionBesoin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private double montantApprox;
    private Date dateDem;
    private Date dateEffet;
    private double montantEffet;
    private boolean isValid;
    
    @ManyToOne
    private Membre membre;
    
    @ManyToOne
    private Responsable responsable;
    
    @ManyToOne
    private TypeBesoin typeBesoin;
    
    // Constructeurs, getters et setters
    
	public ExpressionBesoin() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getMontantApprox() {
		return montantApprox;
	}

	public void setMontantApprox(double montantApprox) {
		this.montantApprox = montantApprox;
	}

	public Date getDateDem() {
		return dateDem;
	}

	public void setDateDem(Date dateDem) {
		this.dateDem = dateDem;
	}

	public Date getDateEffet() {
		return dateEffet;
	}

	public void setDateEffet(Date dateEffet) {
		this.dateEffet = dateEffet;
	}

	public double getMontantEffet() {
		return montantEffet;
	}

	public void setMontantEffet(double montantEffet) {
		this.montantEffet = montantEffet;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public Membre getMembre() {
		return membre;
	}

	public void setMembre(Membre membre) {
		this.membre = membre;
	}

	public Responsable getResponsable() {
		return responsable;
	}

	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
	}

	public TypeBesoin getTypeBesoin() {
		return typeBesoin;
	}

	public void setTypeBesoin(TypeBesoin typeBesoin) {
		this.typeBesoin = typeBesoin;
	}
    
    
    
}
