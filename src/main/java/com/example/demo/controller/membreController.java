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

import com.example.demo.model.Membre;
import com.example.demo.service.membreService;

@RestController
@RequestMapping("/members")
public class membreController {
    
    @Autowired
    private membreService memService;

    @GetMapping
    public ResponseEntity<List<Membre>> getAllMembres(){
        List<Membre> membres = memService.getAllMembres();
        return new ResponseEntity<>(membres, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Membre> getMembreById(@PathVariable Integer id){
        return new ResponseEntity<>(memService.getMembreById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Membre> addMember(@RequestBody Membre membre){
        Membre newMembre = memService.addMembre(membre);
        return new ResponseEntity<>(newMembre, HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Membre> editMember(@PathVariable Integer id, @RequestBody Membre membre){
        Membre exMembre = memService.updateMembre(membre, id);
        if(exMembre != null)
            return new ResponseEntity<>(exMembre, HttpStatus.OK);
        else 
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Membre> deleteMembre(@PathVariable Integer id){
        boolean deletedMembre = memService.deleteMembre(id);
        if(deletedMembre)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else 
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
