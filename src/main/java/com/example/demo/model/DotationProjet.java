package com.example.demo.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
// setters and getters
// constructors with an without args
@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
public class DotationProjet {
    @EmbeddedId
    private DotationProjetPK DotationProjetpk;
    
    private double dotation;
    private boolean isRespoProjet;
	public DotationProjetPK getDotationProjetpk() {
		return DotationProjetpk;
	}
    
}
