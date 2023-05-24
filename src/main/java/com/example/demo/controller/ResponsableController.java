package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Responsable;
import com.example.demo.service.ResponsableService;

import java.util.List;

@RestController
@RequestMapping("/responsables")
public class ResponsableController {

    @Autowired
    private ResponsableService responsableService;

    @PostMapping
    public ResponseEntity<Responsable> createResponsable(@RequestBody Responsable responsable) {
        Responsable createdResponsable = responsableService.createResponsable(responsable);
        return new ResponseEntity<>(createdResponsable, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Responsable> updateResponsable(@PathVariable Integer id, @RequestBody Responsable responsable) {
        Responsable updatedResponsable = responsableService.updateResponsable(responsable);
        if (updatedResponsable != null) {
            return new ResponseEntity<>(updatedResponsable, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResponsable(@PathVariable Integer id) {
        responsableService.deleteResponsable(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Responsable> getResponsableById(@PathVariable Integer id) {
        Responsable responsable = responsableService.getResponsableById(id);
        if (responsable != null) {
            return new ResponseEntity<>(responsable, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Responsable>> getAllResponsables() {
        List<Responsable> responsables = responsableService.getAllResponsables();
        return new ResponseEntity<>(responsables, HttpStatus.OK);
    }


}
