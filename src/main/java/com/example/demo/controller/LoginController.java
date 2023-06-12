package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Admin;
import com.example.demo.model.AuthResponse;
import com.example.demo.model.LoginRequest;
import com.example.demo.model.Membre;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.membreRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class LoginController {

    private AdminRepository adminRepository;
    private membreRepository _membreRepository;

    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();
        
        Admin admin = adminRepository.findByEmail(email);
        if (admin != null && admin.getPassword().equals(password)) {
            
            String token = generateToken(admin.getId(), "ADMIN");
            return new ResponseEntity<>(new AuthResponse(token, "ADMIN"), HttpStatus.OK);
        }

        // Find member by email
        Membre member = _membreRepository.findByEmail(email);
        if (member != null && member.getPassword().equals(password)) {
            // Successful login as member
           
            if(member.isDirector()){
                String token = generateToken(member.getId(), "DIRECTOR");
                return new ResponseEntity<>(new AuthResponse(token, "DIRECTOR"), HttpStatus.OK);
            } else {
                String token = generateToken(member.getId(), "MEMBRE");
                return new ResponseEntity<>(new AuthResponse(token, "MEMBRE"), HttpStatus.OK);
            }
            
        }

        // Responsable responsable = responsableRepository.findByEmail(email);
        // if(responsable != null && responsable.getPassword().equals(password)) {
        //     if(responsable.get)
        // }

        // Invalid login credentials
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    
    }

    private String generateToken(Integer id, String role) {
        return role+"+"+id;
    }
    
    // private String determineUserRole(String username) {
    //     // Implement your logic to determine the role of the user based on the username
    //     // You can query the database or any other method to determine the role
        
    //     // For simplicity, let's assume a static mapping between usernames and roles
    //     if (username.equals("admin")) {
    //         return "admin";
    //     } else if (username.equals("membre")) {
    //         return "membre";
    //     } else if (username.equals("responsable_marche")) {
    //         return "responsable_marche";
    //     } else if (username.equals("responsable_finance")) {
    //         return "responsable_finance";
    //     } else if (username.equals("directeur")) {
    //         return "directeur";
    //     }
        
    //     return null; // If the role cannot be determined
    // }
}
