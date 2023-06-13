package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.ExpressionBesoin;

public interface expressionbesoinRepository extends JpaRepository<ExpressionBesoin, Integer>{
	
    @Query("select e from ExpressionBesoin e join e.typeBesoin t where t.id = 2 and e.isValid = true")
	List<ExpressionBesoin> getValidAndTypeBesoin();


}
