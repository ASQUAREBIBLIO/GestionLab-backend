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

import com.example.demo.model.TypeBesoin;
import com.example.demo.service.typebesoinService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/typebesoins")
public class TypeBesoinController {

    private typebesoinService _typebesoinService;

    @GetMapping
    public ResponseEntity<List<TypeBesoin>> getAllTypesBesoin(){
        return new ResponseEntity<>(_typebesoinService.getAllTypesBesoin(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TypeBesoin> createTypeBesoin(@RequestBody TypeBesoin typeBesoin){
        return new ResponseEntity<>(_typebesoinService.createTypeBesoin(typeBesoin), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeBesoin> getTypeBesoinById(@PathVariable("id") int typeId){
        return new ResponseEntity<>(_typebesoinService.getTypeBesoinById(typeId), HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<TypeBesoin> updateProjet(@RequestBody TypeBesoin typeBesoin, @PathVariable("id") int typeId){
        TypeBesoin uTypeBesoin = _typebesoinService.updateTypeBesoin(typeBesoin, typeId);
        if(uTypeBesoin != null){
            return new ResponseEntity<>(uTypeBesoin, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProjet(@PathVariable("id") int typeId){
        _typebesoinService.deleteTypeBesoin(typeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
