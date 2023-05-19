package com.example.demo.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;


@Entity
public class DotationProjet {
    @EmbeddedId
    private DotationProjetPK DotationProjetpk;
    
    private double dotation;
    private boolean isRespoProjet;
	public DotationProjet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DotationProjetPK getDotationProjetpk() {
		return DotationProjetpk;
	}
	public void setDotationProjetpk(DotationProjetPK dotationProjetpk) {
		DotationProjetpk = dotationProjetpk;
	}
	public double getDotation() {
		return dotation;
	}
	public void setDotation(double dotation) {
		this.dotation = dotation;
	}
	public boolean isRespoProjet() {
		return isRespoProjet;
	}
	public void setRespoProjet(boolean isRespoProjet) {
		this.isRespoProjet = isRespoProjet;
	}
    
    
    
    
    
}
