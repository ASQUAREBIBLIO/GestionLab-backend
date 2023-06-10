package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Admin;
import com.example.demo.model.LoginRequest;
import com.example.demo.model.LoginResponse;
import com.example.demo.model.Membre;
import com.example.demo.model.Responsable;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.ResponsableRepository;
import com.example.demo.repository.membreRepository;

@RestController
public class LoginController {

    @Autowired
    private AdminRepository adminRepository;
    
    @Autowired
    private membreRepository membreRepository;
    
    @Autowired
    private ResponsableRepository responsableMarcheRepository;
    
    /*@Autowired
    private ResponsableFinanceRepository responsableFinanceRepository;
    
    @Autowired
    private DirecteurRepository directeurRepository;*/
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        // Perform authentication logic here, such as verifying username and password
        
        // Assuming authentication is successful
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        
        // Determine the role of the user
        String role = determineUserRole(username);
        
        // Based on the role, fetch the user information from the appropriate table
        if (role.equals("admin")) {
            Admin admin = adminRepository.findByNom(username);
            // Handle admin-specific logic or return the admin object in the response
        } else if (role.equals("membre")) {
            Membre membre = membreRepository.findByNom(username);
            // Handle membre-specific logic or return the membre object in the response
        } else if (role.equals("responsable_marche")) {
            Responsable responsableMarche = responsableMarcheRepository.findByNom(username);
            // Handle responsable marche-specific logic or return the responsableMarche object in the response
        } else if (role.equals("responsable_finance")) {
            Responsable responsableFinance = responsableMarcheRepository.findByNom(username);
            // Handle responsable finance-specific logic or return the responsableFinance object in the response
        /*} else if (role.equals("directeur")) {
            Directeur directeur = directeurRepository.findByUsername(username);
            // Handle directeur-specific logic or return the directeur object in the response*/
        }
        
        // Create a response object containing the role or any other relevant information
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setRole(role);
        
        // Return the response object in the response body
        return ResponseEntity.ok(loginResponse);
    }
    
    private String determineUserRole(String username) {
        // Implement your logic to determine the role of the user based on the username
        // You can query the database or any other method to determine the role
        
        // For simplicity, let's assume a static mapping between usernames and roles
        if (username.equals("admin")) {
            return "admin";
        } else if (username.equals("membre")) {
            return "membre";
        } else if (username.equals("responsable_marche")) {
            return "responsable_marche";
        } else if (username.equals("responsable_finance")) {
            return "responsable_finance";
        } else if (username.equals("directeur")) {
            return "directeur";
        }
        
        return null; // If the role cannot be determined
    }
}
