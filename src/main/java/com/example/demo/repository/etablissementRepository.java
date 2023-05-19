package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Etablissement;

public interface etablissementRepository extends JpaRepository<Etablissement, Integer> {
    
}
