package com.example.demo.controller;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
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
import com.example.demo.model.Membre;
import com.example.demo.service.laboratoireService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/laboratoires")
public class laboratoireController {

    private laboratoireService _laboratoireService;

    @GetMapping
    public ResponseEntity<List<Laboratoire>> getLaboratoires(){
        return new ResponseEntity<>(_laboratoireService.getLaboratoires(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Laboratoire> getLaboById(@PathVariable Integer id){
        return new ResponseEntity<>(_laboratoireService.getLaboById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Laboratoire> addLaboratoire(@RequestBody Laboratoire labo){
        return new ResponseEntity<>(_laboratoireService.addLaboratoire(labo), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Laboratoire> updateLaboratoire(@RequestBody Laboratoire labo, @PathVariable Integer id){
        Laboratoire newLabo = _laboratoireService.updateLaboratoire(labo, id);
        if(newLabo != null)
            return new ResponseEntity<>(newLabo, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Laboratoire> deleteLaboratoire(@PathVariable Integer id){
        boolean laboToDelete = _laboratoireService.deleteLaboratoire(id);
        if(laboToDelete)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else 
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}/membres")
    public ResponseEntity<List<Membre>> getAllMembresOfLaboratoire(@PathVariable("id") String nomLabo){
        return new ResponseEntity<>(_laboratoireService.getAllMembresOfLaboratoire(nomLabo), HttpStatus.OK);
    }

    @PostMapping("/{id}/membres")
    public ResponseEntity<Laboratoire> addMembreToLaboratoire(
            @PathVariable("id") String laboNom,
            @RequestBody Membre membre
    ) throws NotFoundException {
        Laboratoire laboratoire = _laboratoireService.addMembreToLaboratoire(laboNom, membre);
        return new ResponseEntity<>(laboratoire, HttpStatus.CREATED);
    }

}
