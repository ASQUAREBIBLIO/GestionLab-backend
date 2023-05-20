package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.laboratoireRepository;
import com.example.demo.repository.membreRepository;
import com.example.demo.model.Laboratoire;
import com.example.demo.model.Membre;

@Service
public class laboratoireService {

    @Autowired
    private laboratoireRepository laboRepo;
    private membreRepository memRepo;

    public List<Laboratoire> getLaboratoires(){
        return laboRepo.findAll();
    }

    public Laboratoire getLaboById(Integer id){
        return laboRepo.findById(id).orElse(null);
    }

    public Laboratoire addLaboratoire(Laboratoire lab){
        return laboRepo.save(lab);
    }
    
    public Laboratoire updateLaboratoire(Laboratoire lab, Integer id){
        Laboratoire exLabo = laboRepo.findById(id).orElse(null);
        if(exLabo != null){
            exLabo.setNomLabo(lab.getNomLabo());
            return laboRepo.save(exLabo);
        } else return null;
    }

    public boolean deleteLaboratoire(Integer id){
        Laboratoire lab  = laboRepo.findById(id).get();
        if(laboRepo.existsById(id)) {
            List<Membre> membres = lab.getMembres();
            for(Membre membre : membres) memRepo.delete(membre);
            laboRepo.deleteById(id);
            return true;
        } else return false; 
    }
}
