package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.repository.etablissementRepository;

import lombok.AllArgsConstructor;

import com.example.demo.model.Etablissement;
import com.example.demo.model.Laboratoire;

@Service
@AllArgsConstructor
public class etablissementService {
    
    private etablissementRepository _etablissementRepository;

    public List<Etablissement> getEtablissements(){
        return _etablissementRepository.findAll();
    }

    public List<Laboratoire> getAllLaboratoiresOfEtablissement(Integer etablissementId){
        Etablissement etablissement = _etablissementRepository.findById(etablissementId).get();
        return etablissement.getLaboratoires();
    }

    public Etablissement getEtabById(Integer id){
        return _etablissementRepository.findById(id).orElse(null);
    }

    public Etablissement addEtablissement(Etablissement etablissement){
        return _etablissementRepository.save(etablissement);
    }

    public Etablissement updateEtablissement(Etablissement etablissement, Integer id){
        Etablissement exEtablissement = _etablissementRepository.findById(id).orElse(null);
        if(exEtablissement != null){
            exEtablissement.setNom(etablissement.getNom());
            exEtablissement.setAdresse(etablissement.getAdresse());
            exEtablissement.setVille(etablissement.getVille());
            exEtablissement.setLaboratoires(etablissement.getLaboratoires());
            return _etablissementRepository.save(exEtablissement);
        } else return null;
    }

    public boolean deleteEtablissement(Integer id){
        Etablissement etabToDelete = _etablissementRepository.findById(id).get();
        if(_etablissementRepository.existsById(id)){
            _etablissementRepository.delete(etabToDelete);
            return true;
        } else return false;
    }

}