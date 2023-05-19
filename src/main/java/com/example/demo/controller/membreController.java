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

import com.example.demo.model.Membre;
import com.example.demo.repository.membreRepository;

@RestController
@RequestMapping("/members")
public class membreController {
    
    @Autowired
    private membreRepository memRepo;

    @GetMapping
    public ResponseEntity<List<Membre>> getAllMembres(){
        List<Membre> membres = memRepo.findAll();
        return new ResponseEntity<>(membres, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Membre> addMember(@RequestBody Membre membre){
        memRepo.save(membre);
        return new ResponseEntity<>(membre, HttpStatus.CREATED);
    }


}
