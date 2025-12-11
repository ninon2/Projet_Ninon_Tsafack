package com.example.Projet_Ninon_Tsafack.dto;

import java.util.Date;

public record CompteCourantDto(
        Long id,
        String numeroCompte,
        double solde,
        Date dateOuverture,
        double decouvertAutorise
) {
}
