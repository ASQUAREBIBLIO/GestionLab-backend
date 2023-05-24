package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Projet;
import com.example.demo.service.ProjetService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/projets")
@AllArgsConstructor
public class ProjetController {
    private ProjetService projetService;

    @GetMapping
    public ResponseEntity<List<Projet>> getProjetList(){
        return new ResponseEntity<>(projetService.getProjetList(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Projet> createProjet(@RequestBody Projet projet){
        return new ResponseEntity<>(projetService.createProjet(projet), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Projet> getProjetById(@PathVariable("id") Integer projetId){
        return new ResponseEntity<>(projetService.getProjetById(projetId), HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Projet> updateProjet(@RequestBody Projet projet, @PathVariable("id") Integer projetId){
        Projet uProjet = projetService.updateProjet(projet, projetId);
        if(uProjet != null){
            return new ResponseEntity<>(uProjet, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Projet> deleteProjet(@PathVariable("id") Integer projetId){
        boolean deletedProjet = projetService.deleteProjet(projetId);
        if(deletedProjet)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
