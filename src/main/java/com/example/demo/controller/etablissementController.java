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

import com.example.demo.service.etablissementService;
import com.example.demo.model.Etablissement;
import com.example.demo.model.Laboratoire;

@RestController
@RequestMapping("/etablissements")
public class etablissementController {
    
    @Autowired
    private etablissementService _etablissementService;

    @GetMapping
    public ResponseEntity<List<Etablissement>> getEtablissements(){
        return new ResponseEntity<>(_etablissementService.getEtablissements(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Etablissement> getEtabById(@PathVariable Integer id){
        return new ResponseEntity<>(_etablissementService.getEtabById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Etablissement> addEtablissement(@RequestBody Etablissement etablissement){
        return new ResponseEntity<>(_etablissementService.addEtablissement(etablissement), HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Etablissement> updateEtablissement(@RequestBody Etablissement etablissement, @PathVariable Integer id){
        Etablissement exEtablissement = _etablissementService.updateEtablissement(etablissement, id);
        if(exEtablissement != null)
            return new ResponseEntity<>(exEtablissement, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Etablissement> deleteEtablissement(@PathVariable Integer id){
        boolean etabToDelete = _etablissementService.deleteEtablissement(id);
        if(etabToDelete)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}/laboratoires")
    public ResponseEntity<List<Laboratoire>> getAllLaboratoiresOfEtablissement(@PathVariable("id") Integer id){
        return new ResponseEntity<>(_etablissementService.getAllLaboratoiresOfEtablissement(id), HttpStatus.OK);
    }
}
