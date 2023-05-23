package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Projet;
import com.example.demo.repository.ProjetRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProjetService {

    private ProjetRepository projetRepository;

    public List<Projet> getProjetList() {
        return projetRepository.findAll();
    }

    public Projet getProjetById(Integer projetId){
        return projetRepository.findById(projetId).get();
    }

    public Projet createProjet(Projet projet){
        return projetRepository.save(projet);
    }

    public Projet updateProjet(Projet projet, Integer projetId){
        Projet oldProjet = projetRepository.findById(projetId).get();
        if(oldProjet != null){
            oldProjet.setNom(projet.getNom());
            oldProjet.setBudget(projet.getBudget());
            oldProjet.setDateDebut(projet.getDateDebut());
            oldProjet.setDateFin(projet.getDateFin());
            return projetRepository.save(oldProjet);
        } else return null;
    }

    public boolean deleteProjet(Integer projetId){
        if(projetRepository.existsById(projetId)){
            projetRepository.deleteById(projetId);
            return true;
        } return false;
    }
}
