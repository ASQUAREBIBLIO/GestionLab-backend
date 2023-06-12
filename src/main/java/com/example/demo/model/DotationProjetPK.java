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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((projetId == null) ? 0 : projetId.hashCode());
		result = prime * result + ((membreId == null) ? 0 : membreId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DotationProjetPK other = (DotationProjetPK) obj;
		if (projetId == null) {
			if (other.projetId != null)
				return false;
		} else if (!projetId.equals(other.projetId))
			return false;
		if (membreId == null) {
			if (other.membreId != null)
				return false;
		} else if (!membreId.equals(other.membreId))
			return false;
		return true;
	}

	

}
