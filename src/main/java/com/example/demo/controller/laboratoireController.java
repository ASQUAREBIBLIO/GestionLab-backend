package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.laboratoireRepository;

import com.example.demo.model.Laboratoire;

@RestController
@RequestMapping("/laboratoires")
public class laboratoireController {

    @Autowired
    private laboratoireRepository laboRepo;

    //Afficher tout les laboratoires
    @GetMapping
    public ResponseEntity<List<Laboratoire>> getLaboratoires(){
        List<Laboratoire> laboratoires = laboRepo.findAll();
        return new ResponseEntity<>(laboratoires, HttpStatus.OK);
    }

    //Ajouter un nouveau laboratoire
    @PostMapping("/add")
    public ResponseEntity<Laboratoire> addLaboratoire(@RequestBody Laboratoire labo){
        laboRepo.save(labo);
        return new ResponseEntity<>(labo, HttpStatus.CREATED);
    }
    
}
