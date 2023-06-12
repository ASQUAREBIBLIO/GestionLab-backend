package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
public class MembreUcaRech {
    @EmbeddedId
    private MembreUcaRechId id;

    @ManyToOne
    @JoinColumn(name = "membreId", updatable = false, insertable = false)
    @JsonIgnore
    private Membre membre;

    @ManyToOne
    @JoinColumn(name = "ucaRechId", updatable = false, insertable = false)
    @JsonIgnore
    private UcaRech ucaRech;

    private double dotationMembre;


}
