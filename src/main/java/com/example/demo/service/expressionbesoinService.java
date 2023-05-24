package com.example.demo.service;


import org.springframework.stereotype.Service;

import com.example.demo.model.ExpressionBesoin;
import com.example.demo.model.Membre;
import com.example.demo.model.Responsable;
import com.example.demo.model.TypeBesoin;
import com.example.demo.repository.expressionbesoinRepository;
import com.example.demo.repository.membreRepository;

import lombok.AllArgsConstructor;

import com.example.demo.repository.ResponsableRepository;
import com.example.demo.repository.TypeBesoinRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class expressionbesoinService {

    private expressionbesoinRepository _expressionBesoinRepository;
    private membreRepository _membreRepository;
    private ResponsableRepository responsableRepository;
    private TypeBesoinRepository typeBesoinRepository;

    public ExpressionBesoin createExpressionBesoin(ExpressionBesoin expressionBesoin, Integer membreId,
                                                  Integer responsableId, String typeBesoinId) {
        Membre membre = _membreRepository.findById(membreId).orElse(null);
        Responsable responsable = responsableRepository.findById(responsableId).orElse(null);
        TypeBesoin typeBesoin = typeBesoinRepository.findById(typeBesoinId).orElse(null);

        if (membre != null && responsable != null && typeBesoin != null) {
            expressionBesoin.setMembre(membre);
            expressionBesoin.setResponsable(responsable);
            expressionBesoin.setTypeBesoin(typeBesoin);

            return _expressionBesoinRepository.save(expressionBesoin);
        }

        return null;
    }

    public ExpressionBesoin updateExpressionBesoin(ExpressionBesoin expressionBesoin, Integer membreId,
                                                  Integer responsableId, String typeBesoinId) {
        Membre membre = _membreRepository.findById(membreId).orElse(null);
        Responsable responsable = responsableRepository.findById(responsableId).orElse(null);
        TypeBesoin typeBesoin = typeBesoinRepository.findById(typeBesoinId).orElse(null);

        if (membre != null && responsable != null && typeBesoin != null) {
            expressionBesoin.setMembre(membre);
            expressionBesoin.setResponsable(responsable);
            expressionBesoin.setTypeBesoin(typeBesoin);

            return _expressionBesoinRepository.save(expressionBesoin);
        }

        return null;
    }

    public void deleteExpressionBesoin(Integer id) {
        _expressionBesoinRepository.deleteById(id);
    }

    public ExpressionBesoin getExpressionBesoinById(Integer id) {
        return _expressionBesoinRepository.findById(id).orElse(null);
    }

    public List<ExpressionBesoin> getAllExpressionBesoins() {
        return _expressionBesoinRepository.findAll();
    }

    // Autres méthodes de service nécessaires

}
