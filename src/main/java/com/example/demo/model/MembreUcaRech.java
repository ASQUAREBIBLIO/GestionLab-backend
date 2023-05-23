package com.example.demo.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
public class MembreUcaRech {
    @EmbeddedId
    private MembreUcaRechId id;

    private double dotationMembre;

    @ManyToOne
    @MapsId("membreId")
    private Membre membre;

    @ManyToOne
    @MapsId("ucaRechId")
    private UcaRech ucaRech;
}
