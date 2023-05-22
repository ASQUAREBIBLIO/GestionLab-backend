package com.example.demo.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.UcaRech;

public interface ucaRechRepository extends JpaRepository<UcaRech, Integer> {
    public UcaRech findByAnnee(Date annee);
}
