package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.etablissementRepository;

import com.example.demo.model.Etablissement;

@Service
public class etablissementService {
    
    @Autowired
    private etablissementRepository etablissementRepo;

    public List<Etablissement> getEtablissements(){
        return etablissementRepo.findAll();
    }

    public Etablissement getEtabById(Integer id){
        return etablissementRepo.findById(id).orElse(null);
    }

    public Etablissement addEtablissement(Etablissement etablissement){
        return etablissementRepo.save(etablissement);
    }

    public Etablissement updateEtablissement(Etablissement etablissement, Integer id){
        Etablissement exEtablissement = etablissementRepo.findById(id).orElse(null);
        if(exEtablissement != null){
            exEtablissement.setNom(etablissement.getNom());
            exEtablissement.setAdresse(etablissement.getAdresse());
            exEtablissement.setVille(etablissement.getVille());
            return etablissementRepo.save(exEtablissement);
        } else return null;
    }

    public boolean deleteEtablissement(Integer id){
        Etablissement etabToDelete = etablissementRepo.findById(id).get();
        if(etablissementRepo.existsById(id)){
            etablissementRepo.delete(etabToDelete);
            return true;
        } else return false;
    }
}