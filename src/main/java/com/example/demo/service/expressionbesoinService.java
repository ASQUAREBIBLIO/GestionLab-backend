package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ExpressionBesoin;
import com.example.demo.model.Membre;
import com.example.demo.model.Responsable;
import com.example.demo.model.TypeBesoin;
import com.example.demo.repository.expressionbesoinRepository;
import com.example.demo.repository.membreRepository;
import com.example.demo.repository.ResponsableRepository;
import com.example.demo.repository.TypeBesoinRepository;

import java.util.List;

@Service
public class expressionbesoinService {

    @Autowired
    private expressionbesoinRepository expressionBesoinRepository;

    @Autowired
    private membreRepository membreRepository;

    @Autowired
    private ResponsableRepository responsableRepository;

    @Autowired
    private TypeBesoinRepository typeBesoinRepository;

    public ExpressionBesoin createExpressionBesoin(ExpressionBesoin expressionBesoin, Integer membreId,
                                                  Integer responsableId, String typeBesoinId) {
        Membre membre = membreRepository.findById(membreId).orElse(null);
        Responsable responsable = responsableRepository.findById(responsableId).orElse(null);
        TypeBesoin typeBesoin = typeBesoinRepository.findById(typeBesoinId).orElse(null);

        if (membre != null && responsable != null && typeBesoin != null) {
            expressionBesoin.setMembre(membre);
            expressionBesoin.setResponsable(responsable);
            expressionBesoin.setTypeBesoin(typeBesoin);

            return expressionBesoinRepository.save(expressionBesoin);
        }

        return null;
    }

    public ExpressionBesoin updateExpressionBesoin(ExpressionBesoin expressionBesoin, Integer membreId,
                                                  Integer responsableId, String typeBesoinId) {
        Membre membre = membreRepository.findById(membreId).orElse(null);
        Responsable responsable = responsableRepository.findById(responsableId).orElse(null);
        TypeBesoin typeBesoin = typeBesoinRepository.findById(typeBesoinId).orElse(null);

        if (membre != null && responsable != null && typeBesoin != null) {
            expressionBesoin.setMembre(membre);
            expressionBesoin.setResponsable(responsable);
            expressionBesoin.setTypeBesoin(typeBesoin);

            return expressionBesoinRepository.save(expressionBesoin);
        }

        return null;
    }

    public void deleteExpressionBesoin(Integer id) {
        expressionBesoinRepository.deleteById(id);
    }

    public ExpressionBesoin getExpressionBesoinById(Integer id) {
        return expressionBesoinRepository.findById(id).orElse(null);
    }

    public List<ExpressionBesoin> getAllExpressionBesoins() {
        return expressionBesoinRepository.findAll();
    }

    // Autres méthodes de service nécessaires

}
