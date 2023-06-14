package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.ExpressionBesoin;

public interface expressionbesoinRepository extends JpaRepository<ExpressionBesoin, Integer>{
	
    @Query("select e from ExpressionBesoin e join e.typeBesoin t where t.id = 2 and e.isValid = true")
	List<ExpressionBesoin> getValidAndTypeBesoin();


    @Query("SELECT eb FROM ExpressionBesoin eb WHERE eb.isValid = true")
    public List<ExpressionBesoin> getValidExpressionBesoins();

    @Query("SELECT eb FROM ExpressionBesoin eb WHERE eb.isValid = false")
    public List<ExpressionBesoin> getInvalidExpressionBesoins();
    
    @Query("select e from ExpressionBesoin e join e.typeBesoin t where t.id = 1 and e.isValid = true")
    public List<ExpressionBesoin> getValidAndTypeBesoinFinance();

}
