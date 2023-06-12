package com.example.demo.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class MembreUcaRechId implements Serializable {

    private Integer membreId;
    private Integer ucaRechId;
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((membreId == null) ? 0 : membreId.hashCode());
        result = prime * result + ((ucaRechId == null) ? 0 : ucaRechId.hashCode());
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
        MembreUcaRechId other = (MembreUcaRechId) obj;
        if (membreId == null) {
            if (other.membreId != null)
                return false;
        } else if (!membreId.equals(other.membreId))
            return false;
        if (ucaRechId == null) {
            if (other.ucaRechId != null)
                return false;
        } else if (!ucaRechId.equals(other.ucaRechId))
            return false;
        return true;
    }
    
    
}
