package com.example.demo.controller;

import com.example.demo.model.ExpressionBesoin;
import com.example.demo.service.expressionbesoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expressionBesoins")
public class ExpressionBesoinController {

    @Autowired
    private expressionbesoinService expressionBesoinService;

    @PostMapping
    public ResponseEntity<ExpressionBesoin> createExpressionBesoin(@RequestBody ExpressionBesoin expressionBesoin,
                                                                   @RequestParam Integer membreId,
                                                                   @RequestParam Integer responsableId,
                                                                   @RequestParam String typeBesoinId) {
        ExpressionBesoin createdExpressionBesoin = expressionBesoinService.createExpressionBesoin(expressionBesoin,
                membreId, responsableId, typeBesoinId);
        if (createdExpressionBesoin != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdExpressionBesoin);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExpressionBesoin> updateExpressionBesoin(@PathVariable Integer id,
                                                                   @RequestBody ExpressionBesoin expressionBesoin,
                                                                   @RequestParam Integer membreId,
                                                                   @RequestParam Integer responsableId,
                                                                   @RequestParam String typeBesoinId) {
        ExpressionBesoin updatedExpressionBesoin = expressionBesoinService.updateExpressionBesoin(expressionBesoin,
                membreId, responsableId, typeBesoinId);
        if (updatedExpressionBesoin != null) {
            return ResponseEntity.ok(updatedExpressionBesoin);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpressionBesoin(@PathVariable Integer id) {
        expressionBesoinService.deleteExpressionBesoin(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpressionBesoin> getExpressionBesoinById(@PathVariable Integer id) {
        ExpressionBesoin expressionBesoin = expressionBesoinService.getExpressionBesoinById(id);
        if (expressionBesoin != null) {
            return ResponseEntity.ok(expressionBesoin);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<ExpressionBesoin>> getAllExpressionBesoins() {
        List<ExpressionBesoin> expressionBesoins = expressionBesoinService.getAllExpressionBesoins();
        return ResponseEntity.ok(expressionBesoins);
    }

    // Autres méthodes de contrôleur nécessaires

}
