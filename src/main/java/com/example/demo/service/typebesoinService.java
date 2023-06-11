package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.TypeBesoin;
import com.example.demo.repository.TypeBesoinRepository;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class typebesoinService {

    private TypeBesoinRepository typeBesoinRepository;

    public List<TypeBesoin> getAllTypesBesoin() {
        return typeBesoinRepository.findAll();
    }

    public TypeBesoin getTypeBesoinById(int id) {
        Optional<TypeBesoin> typeBesoinOptional = typeBesoinRepository.findById(id);
        return typeBesoinOptional.orElse(null);
    }

    public TypeBesoin createTypeBesoin(TypeBesoin typeBesoin) {
        return typeBesoinRepository.save(typeBesoin);
    }

    public TypeBesoin updateTypeBesoin(TypeBesoin typeBesoin, int typeId) {
        TypeBesoin uTypeBesoin = typeBesoinRepository.findById(typeId).get();
        if(uTypeBesoin != null){
            uTypeBesoin.setType(typeBesoin.getType());
            uTypeBesoin.setExpressionsBesoin(typeBesoin.getExpressionsBesoin());
            return typeBesoinRepository.save(typeBesoin);
        } else return null;
       
    }

    public void deleteTypeBesoin(int id) {
        typeBesoinRepository.deleteById(id);
    }

    // Autres méthodes de service nécessaires

}

