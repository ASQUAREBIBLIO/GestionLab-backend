package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.demo.model.Laboratoire;
import com.example.demo.service.laboratoireService;

@RestController
@RequestMapping("/laboratoires")
public class laboratoireController {

    @Autowired
    private laboratoireService labService;

    @GetMapping
    public ResponseEntity<List<Laboratoire>> getLaboratoires(){
        return new ResponseEntity<>(labService.getLaboratoires(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Laboratoire> getLaboById(@PathVariable Integer id){
        return new ResponseEntity<>(labService.getLaboById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Laboratoire> addLaboratoire(@RequestBody Laboratoire labo){
        return new ResponseEntity<>(labService.addLaboratoire(labo), HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Laboratoire> updateLaboratoire(@RequestBody Laboratoire labo, @PathVariable Integer id){
        Laboratoire newLabo = labService.updateLaboratoire(labo, id);
        if(newLabo != null)
            return new ResponseEntity<>(newLabo, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Laboratoire> deleteLaboratoire(@PathVariable Integer id){
        boolean laboToDelete = labService.deleteLaboratoire(id);
        if(laboToDelete)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else 
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
