package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ADMINS")
@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
public class Admin {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 20)
    private String nom;

    @Column(length = 20)
    private String prenom;
    private String email;

    private String password;


    @OneToMany(mappedBy = "admin")
    private Set<Membre> membres = new HashSet<>();

    @OneToMany(mappedBy = "admin")
    private Set<Membre> responsables = new HashSet<>();
}
