package com.example.Projet_Ninon_Tsafack.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@DiscriminatorValue("CC")
public class CompteCourant extends Compte {

    private double decouvertAutorise = 1000;

    public CompteCourant(String numeroCompte, double solde, Date dateOuverture, double decouvertAutorise) {
        super(numeroCompte, solde, dateOuverture);
        this.decouvertAutorise = decouvertAutorise;
    }
}
