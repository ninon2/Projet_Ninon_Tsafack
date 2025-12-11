package com.example.Projet_Ninon_Tsafack.dto;

import java.util.Date;

public record CompteEpargneDto(
        Long id,
        String numeroCompte,
        double solde,
        Date dateOuverture,
        double tauxRemuneration
) {
}
