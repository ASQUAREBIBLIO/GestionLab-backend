package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Projet;

public interface ProjectRepository extends JpaRepository<Projet, Integer> {
    
}
