package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.repository.membreRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

import com.example.demo.model.Membre;

@Service
@Transactional
@AllArgsConstructor
public class membreService {

    private membreRepository _membreRepository;

    public List<Membre> getAllMembres(){
        return _membreRepository.findAll();
    }

    public Membre getMembreById(Integer id){
        return _membreRepository.findById(id).orElse(null);
    }

    public Membre addMembre(Membre membre){
        return _membreRepository.save(membre);
    }

    public Membre updateMembre(Membre membre, Integer id){
        Membre exMembre = _membreRepository.findById(id).orElse(null);
        if(exMembre != null) {
           exMembre.setNom(membre.getNom());
           exMembre.setPrenom(membre.getPrenom());
           exMembre.setPassword(membre.getPassword());
           exMembre.setEmail(membre.getEmail());
           exMembre.setDirector(membre.isDirector());
           return _membreRepository.save(exMembre);
        } else return null;
    }

    public void addUcaRechToMembre(Integer membreId, Integer ucaRechId){
       
      
    }


    public void setMembreAsDirector(String email){
        Membre membre = _membreRepository.findByEmail(email);
        membre.setDirector(true);
    }
    
    public boolean deleteMembre(Integer id){
        if(_membreRepository.existsById(id)){
            _membreRepository.deleteById(id);
            return true;
        } else return false;
    }
}
