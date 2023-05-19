package com.example.demo.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
public class DotationProjetPK {
	private int idProjet;
	private int id;

}
