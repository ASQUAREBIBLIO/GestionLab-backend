package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Membre;
import com.example.demo.model.MembreUcaRech;
import com.example.demo.service.membreService;

@RestController
@RequestMapping("/membres")
public class membreController {
    
    @Autowired
    private membreService _membreService;

    @GetMapping
    public ResponseEntity<List<Membre>> getAllMembres(){
        List<Membre> membres = _membreService.getAllMembres();
        return new ResponseEntity<>(membres, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Membre> getMembreById(@PathVariable Integer id){
        return new ResponseEntity<>(_membreService.getMembreById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Membre> addMember(@RequestBody Membre membre){
        Membre newMembre = _membreService.addMembre(membre);
        return new ResponseEntity<>(newMembre, HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Membre> editMember(@PathVariable Integer id, @RequestBody Membre membre){
        Membre exMembre = _membreService.updateMembre(membre, id);
        if(exMembre != null)
            return new ResponseEntity<>(exMembre, HttpStatus.OK);
        else 
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Membre> deleteMembre(@PathVariable Integer id){
        boolean deletedMembre = _membreService.deleteMembre(id);
        if(deletedMembre)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else 
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/{membreId}/ucaRechs/{ucaRechId}")
    public ResponseEntity<Membre> addUcaRechToMembre(
            @PathVariable Integer membreId,
            @PathVariable Integer ucaRechId,
            @RequestBody MembreUcaRech membreUcaRech
    ) throws NotFoundException {
        Membre membre = _membreService.addUcaRechToMembre(membreId, ucaRechId, membreUcaRech.getDotationMembre());
        return ResponseEntity.ok(membre);
    }


}
