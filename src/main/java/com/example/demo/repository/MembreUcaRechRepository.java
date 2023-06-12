package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.MembreUcaRech;
import com.example.demo.model.MembreUcaRechId;

public interface MembreUcaRechRepository extends JpaRepository<MembreUcaRech, MembreUcaRechId> {
    
}
