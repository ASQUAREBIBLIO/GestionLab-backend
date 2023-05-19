package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.membreRepository;

import com.example.demo.model.Membre;

@Service
public class membreService {

    @Autowired
    private membreRepository memRepo;

    public List<Membre> getAllMembres(){
        return memRepo.findAll();
    }

    public Membre getMembre(Integer id){
        return memRepo.findById(id).orElse(null);
    }

    public Membre addMembre(Membre membre){
        return memRepo.save(membre);
    }

    public Membre updateMembre(Membre membre, Integer id){
        Membre exMembre = memRepo.findById(id).orElse(null);
        if(exMembre != null) {
           exMembre.setNom(membre.getNom());
           exMembre.setPrenom(membre.getPrenom());
           exMembre.setEmail(membre.getEmail());
           exMembre.setDirector(membre.isDirector());
           return memRepo.save(exMembre);
        } else return null;
    }
    
    public boolean deleteMembre(Integer id){
        if(memRepo.existsById(id)){
            memRepo.deleteById(id);
            return true;
        } else return false;
    }
}
