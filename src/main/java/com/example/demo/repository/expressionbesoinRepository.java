package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.ExpressionBesoin;

public interface expressionbesoinRepository extends JpaRepository<ExpressionBesoin, Integer>{

    @Query("SELECT eb FROM ExpressionBesoin eb WHERE eb.isValid = true")
    public List<ExpressionBesoin> getValidExpressionBesoins();

}
