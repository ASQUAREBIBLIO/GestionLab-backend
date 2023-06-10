package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Responsable;

public interface ResponsableRepository extends JpaRepository<Responsable, Integer> {
	
	Responsable findByNom(String nom);

}
