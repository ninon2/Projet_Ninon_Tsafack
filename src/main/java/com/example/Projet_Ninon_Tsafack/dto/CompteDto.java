package com.example.Projet_Ninon_Tsafack.dto;

import java.util.Date;

public record CompteDto(
        Long id,
        String numeroCompte,
        double solde,
        Date dateOuverture,
        String typeCompte
) {
}
