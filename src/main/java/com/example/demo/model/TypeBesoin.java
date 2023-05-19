package com.example.demo.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class TypeBesoin {
    @Id
    private String type;
    
    @OneToMany(mappedBy = "typeBesoin")
    private List<ExpressionBesoin> expressionsBesoin;
    
}
