package com.example.Projet_Ninon_Tsafack.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_compte", discriminatorType = DiscriminatorType.STRING)
public abstract class Compte {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String numeroCompte;

    private double solde;

    @Temporal(TemporalType.DATE)
    private Date dateOuverture;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Compte(String numeroCompte, double solde, Date dateOuverture) {
        this.numeroCompte = numeroCompte;
        this.solde = solde;
        this.dateOuverture = dateOuverture;
    }
}