package com.example.demo.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class DotationProjetPK {
	private int idProjet;
	private int id;
	public int getIdProjet() {
		return idProjet;
	}
	public void setIdProjet(int idProjet) {
		this.idProjet = idProjet;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public DotationProjetPK() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
