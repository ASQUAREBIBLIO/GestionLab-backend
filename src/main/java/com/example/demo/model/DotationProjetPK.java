package com.example.demo.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
public class DotationProjetPK implements Serializable {
	private Integer projetId;
	private Integer membreId;

}
