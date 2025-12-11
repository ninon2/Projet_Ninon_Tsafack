package com.example.Projet_Ninon_Tsafack.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte {

    private double tauxRemuneration = 0.03;

    public CompteEpargne(String numeroCompte, double solde, Date dateOuverture, double tauxRemuneration) {
        super(numeroCompte, solde, dateOuverture);
        this.tauxRemuneration = tauxRemuneration;
    }
}
