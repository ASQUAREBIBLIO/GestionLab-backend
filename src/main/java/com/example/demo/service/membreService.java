package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.repository.membreRepository;
import com.example.demo.repository.ucaRechRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

import com.example.demo.model.Membre;
import com.example.demo.model.UcaRech;

@Service
@Transactional
@AllArgsConstructor
public class membreService {

    private membreRepository _membreRepository;
    private ucaRechRepository _ucaRechRepository;

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
           exMembre.setUcaRechs(membre.getUcaRechs());
           return _membreRepository.save(exMembre);
        } else return null;
    }

    public void addUcaRechToMembre(Integer membreId, Integer ucaRechId){
        Membre membre = _membreRepository.findById(membreId).get();
        UcaRech ucaDotation = _ucaRechRepository.findById(ucaRechId).get();
        membre.getUcaRechs().add(ucaDotation);
        _membreRepository.save(membre);
      
    }

    public List<Membre> getMembersByUcaRech(Date ucaRechAnnee) {
        return _membreRepository.findByUcaRech(ucaRechAnnee);
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
