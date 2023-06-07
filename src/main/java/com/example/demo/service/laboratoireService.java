package com.example.demo.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.repository.laboratoireRepository;

import lombok.AllArgsConstructor;

import com.example.demo.model.Laboratoire;
import com.example.demo.model.Membre;

@Service
@AllArgsConstructor
public class laboratoireService {

    private laboratoireRepository _laboratoireRepository;

    public List<Laboratoire> getLaboratoires(){
        return _laboratoireRepository.findAll();
    }

    public List<Membre> getAllMembresOfLaboratoire(String laboNom){
        Laboratoire laboratoire = _laboratoireRepository.getLaboratoireByNomLabo(laboNom);
        return laboratoire.getMembres();
    }

    public Laboratoire getLaboById(Integer id){
        return _laboratoireRepository.findById(id).orElse(null);
    }

    public Laboratoire addLaboratoire(Laboratoire lab){
        return _laboratoireRepository.save(lab);
    }
    
    public Laboratoire updateLaboratoire(Laboratoire lab, Integer id){
        Laboratoire exLabo = _laboratoireRepository.findById(id).orElse(null);
        if(exLabo != null){
            exLabo.setNomLabo(lab.getNomLabo());
            exLabo.setEtablissement(lab.getEtablissement());
            exLabo.setMembres(lab.getMembres());
            return _laboratoireRepository.save(exLabo);
        } else return null;
    }

    public boolean deleteLaboratoire(Integer id){
        Laboratoire lab  = _laboratoireRepository.findById(id).get();
        if(_laboratoireRepository.existsById(id)) {
            for(Membre m: lab.getMembres()) {
                m.setLaboratoire(null);
                _laboratoireRepository.save(lab);
            }
            _laboratoireRepository.deleteById(id);
            return true;
        } else return false; 
    }

    public Laboratoire addMembreToLaboratoire(String laboNom, Membre membre) {
        Laboratoire laboratoire = _laboratoireRepository.getLaboratoireByNomLabo(laboNom);

        membre.setLaboratoire(laboratoire);
        laboratoire.getMembres().add(membre);

        return _laboratoireRepository.save(laboratoire);
    }
}
