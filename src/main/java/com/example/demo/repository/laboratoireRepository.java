package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Laboratoire;

public interface laboratoireRepository extends JpaRepository<Laboratoire, Integer> {
    
}
