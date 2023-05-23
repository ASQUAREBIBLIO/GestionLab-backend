package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.UcaRech;
import com.example.demo.repository.ucaRechRepository;

@Service
public class ucaRechService {

    @Autowired
    private ucaRechRepository ucaRechRepository;

    public List<UcaRech> getAllUcaRechs() {
        return ucaRechRepository.findAll();
    }

    public UcaRech getUcaRechById(Integer id) {
        return ucaRechRepository.findById(id).orElse(null);
    }

    public UcaRech createUcaRech(UcaRech ucaRech) {
        return ucaRechRepository.save(ucaRech);
    }

    public UcaRech updateUcaRech(Integer id, UcaRech updatedUcaRech) {
        UcaRech ucaRech = ucaRechRepository.findById(id).orElse(updatedUcaRech);

        ucaRech.setAnnee(updatedUcaRech.getAnnee());
        ucaRech.setSource(updatedUcaRech.getSource());
        ucaRech.setBudget(updatedUcaRech.getBudget());

        return ucaRechRepository.save(ucaRech);
    }

    public void deleteUcaRech(Integer id) {
        ucaRechRepository.deleteById(id);
    }
    
}
