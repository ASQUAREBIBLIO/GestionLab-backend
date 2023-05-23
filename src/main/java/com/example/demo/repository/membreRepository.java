package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Membre;


public interface membreRepository extends JpaRepository<Membre, Integer> {
    public Membre findByEmail(String email);

    @Query("SELECT DISTINCT m FROM Membre m JOIN m.ucaRechs u WHERE u.annee = :anneeUcaRech")
    List<Membre> findByUcaRech(@Param("anneeUcaRech") Date annee);
}
