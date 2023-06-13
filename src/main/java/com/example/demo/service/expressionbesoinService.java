package com.example.demo.service;


import org.springframework.stereotype.Service;

import com.example.demo.model.ExpressionBesoin;
import com.example.demo.repository.expressionbesoinRepository;

import lombok.AllArgsConstructor;

import java.util.List;

@Service
@AllArgsConstructor
public class expressionbesoinService {

    private expressionbesoinRepository _expressionBesoinRepository;

    public ExpressionBesoin createExpressionBesoin(ExpressionBesoin expressionBesoin) {
        expressionBesoin.setResponsable(null);
        return _expressionBesoinRepository.save(expressionBesoin);
    }

    public ExpressionBesoin updateExpressionBesoin(Integer id, ExpressionBesoin expressionBesoin) {
        ExpressionBesoin e = _expressionBesoinRepository.findById(id).orElse(null);
        if (e!=null) {
            e.setDateDem(expressionBesoin.getDateDem());
            e.setMontantApprox(expressionBesoin.getMontantApprox());

            return _expressionBesoinRepository.save(e);
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
