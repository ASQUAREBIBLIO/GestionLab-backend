package com.example.demo.controller;

import com.example.demo.model.ExpressionBesoin;
import com.example.demo.repository.expressionbesoinRepository;
import com.example.demo.service.expressionbesoinService;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expressionBesoins")
@AllArgsConstructor
public class ExpressionBesoinController {

    @Autowired
    private expressionbesoinService _expressionBesoinService;
    
    @Autowired
    private expressionbesoinRepository expressionbesoinrepository;

    @PostMapping
    public ResponseEntity<ExpressionBesoin> createExpressionBesoin(@RequestBody ExpressionBesoin expressionBesoin) {
       return new ResponseEntity<>(_expressionBesoinService.createExpressionBesoin(expressionBesoin), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExpressionBesoin> updateExpressionBesoin(@PathVariable Integer id,
                                                                   @RequestBody ExpressionBesoin expressionBesoin) {
        ExpressionBesoin updatedExpressionBesoin = _expressionBesoinService.updateExpressionBesoin(id, expressionBesoin);
        if (updatedExpressionBesoin != null) {
            return ResponseEntity.ok(updatedExpressionBesoin);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpressionBesoin(@PathVariable Integer id) {
        _expressionBesoinService.deleteExpressionBesoin(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpressionBesoin> getExpressionBesoinById(@PathVariable Integer id) {
        ExpressionBesoin expressionBesoin = _expressionBesoinService.getExpressionBesoinById(id);
        if (expressionBesoin != null) {
            return ResponseEntity.ok(expressionBesoin);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<ExpressionBesoin>> getAllExpressionBesoins() {
        List<ExpressionBesoin> expressionBesoins = _expressionBesoinService.getAllExpressionBesoins();
        return ResponseEntity.ok(expressionBesoins);
    }
    
    @GetMapping("/marche")
    public ResponseEntity<List<ExpressionBesoin>> getValidExpressionBesoinsByType() {
        List<ExpressionBesoin> expressionBesoins = expressionbesoinrepository.getValidAndTypeBesoin();
        return ResponseEntity.ok(expressionBesoins);
    }
    
    @GetMapping("/finance")
    public ResponseEntity<List<ExpressionBesoin>> getValidExpressionBesoinsByTypeFinance() {
        List<ExpressionBesoin> expressionBesoins = expressionbesoinrepository.getValidAndTypeBesoinFinance();
        return ResponseEntity.ok(expressionBesoins);
    }


    @GetMapping("/v")
    public ResponseEntity<List<ExpressionBesoin>> getValidExpressions(){
        return new ResponseEntity<>(_expressionBesoinService.getValidExpressionBesoins(), HttpStatus.OK);
    }

     @GetMapping("/inv")
    public ResponseEntity<List<ExpressionBesoin>> getInvalidExpressions(){
        return new ResponseEntity<>(_expressionBesoinService.getInvalidExpressionBesoins(), HttpStatus.OK);
    }

    @PutMapping("/{id}/v")
    public ResponseEntity<ExpressionBesoin> valider(@PathVariable("id") Integer eId){
        ExpressionBesoin e = _expressionBesoinService.getExpressionBesoinById(eId);
        return new ResponseEntity<ExpressionBesoin>(_expressionBesoinService.valider(e), HttpStatus.OK);
    }

    // Autres méthodes de contrôleur nécessaires

}
