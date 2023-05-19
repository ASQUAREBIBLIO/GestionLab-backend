package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Membre;

public interface membreRepository extends JpaRepository<Membre, Integer> {
    
}
