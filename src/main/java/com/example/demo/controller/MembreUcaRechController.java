package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.MembreUcaRech;
import com.example.demo.repository.MembreUcaRechRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/membres/dotations")
public class MembreUcaRechController {

    private MembreUcaRechRepository membreUcaRechRepository;

    @GetMapping
    public ResponseEntity<List<MembreUcaRech>> getMembreUcaRech(){
        return new ResponseEntity<>(membreUcaRechRepository.findAll(), HttpStatus.OK );
    }

    @PostMapping
    public ResponseEntity<MembreUcaRech> createMembreUcaRech(@RequestBody MembreUcaRech membreUcaRech){
        return new ResponseEntity<MembreUcaRech>(membreUcaRechRepository.save(membreUcaRech), HttpStatus.CREATED);
    }
}
