package com.example.demo.model;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
public class Laboratoire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String nomLabo;
    
    @ManyToOne()
    @JoinColumn (name = "etablissement_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Etablissement etablissement;
    
    @OneToMany(mappedBy="laboratoire", fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JsonIgnore
	private List<Membre> membres;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    public void clearMembers(){
        this.membres.clear();
    }
    
        
}
