package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.UcaRech;

public interface ucaRechRepository extends JpaRepository<UcaRech, Integer> {
    
}
