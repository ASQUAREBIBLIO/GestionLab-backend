package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.Responsable;
import com.example.demo.model.ExpressionBesoin;
import com.example.demo.repository.ResponsableRepository;
//import com.example.demo.repository.expressionbesoinRepository;

import lombok.AllArgsConstructor;

import java.util.List;

@Service
@AllArgsConstructor
public class ResponsableService {

    private ResponsableRepository responsableRepository;

    public Responsable createResponsable(Responsable responsable) {
        return responsableRepository.save(responsable);
    }

    public Responsable updateResponsable(Responsable responsable) {
        return responsableRepository.save(responsable);
    }

    public void deleteResponsable(Integer id) {
        responsableRepository.deleteById(id);
    }

    public Responsable getResponsableById(Integer id) {
        return responsableRepository.findById(id).orElse(null);
    }

    public List<Responsable> getAllResponsables() {
        return responsableRepository.findAll();
    }

    public List<ExpressionBesoin> getExpressionBesoinsByResponsableId(Integer responsableId) {
        Responsable responsable = responsableRepository.findById(responsableId).orElse(null);
        if (responsable != null) {
            return responsable.getExpressionsBesoin();
        }
        return null;
    }


}
