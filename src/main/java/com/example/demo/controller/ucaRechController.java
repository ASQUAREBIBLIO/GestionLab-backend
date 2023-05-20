package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UcaRech;
import com.example.demo.service.ucaRechService;

@RestController
@RequestMapping("/UcaRecherce")
public class ucaRechController {
    
    @Autowired
    private ucaRechService _ucaRechService;

    @GetMapping
    public ResponseEntity<List<UcaRech>> getAllUcaRechs() {
        List<UcaRech> ucaRechs = _ucaRechService.getAllUcaRechs();
        return ResponseEntity.ok(ucaRechs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UcaRech> getUcaRechById(@PathVariable Integer id) {
        UcaRech ucaRech = _ucaRechService.getUcaRechById(id);
        return ResponseEntity.ok(ucaRech);
    }

    @PostMapping("/add")
    public ResponseEntity<UcaRech> createUcaRech(@RequestBody UcaRech ucaRech) {
        UcaRech createdUcaRech = _ucaRechService.createUcaRech(ucaRech);
        return ResponseEntity.ok(createdUcaRech);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UcaRech> updateUcaRech(@PathVariable Integer id, @RequestBody UcaRech updatedUcaRech) {
        UcaRech ucaRech = _ucaRechService.updateUcaRech(id, updatedUcaRech);
        return ResponseEntity.ok(ucaRech);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUcaRech(@PathVariable Integer id) {
        _ucaRechService.deleteUcaRech(id);
        return ResponseEntity.noContent().build();
    }
}
