package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Admin;
import com.example.demo.repository.AdminRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private AdminRepository adminRepository;

    @PostMapping("/regiter")
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin){
        return new ResponseEntity<>(adminRepository.save(admin), HttpStatus.CREATED);
    }
}