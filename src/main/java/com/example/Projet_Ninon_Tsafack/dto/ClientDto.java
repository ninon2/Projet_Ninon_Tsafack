package com.example.Projet_Ninon_Tsafack.dto;

import java.util.List;

public record ClientDto(
        Long id,
        String nom,
        String prenom,
        String adresse,
        String codePostal,
        String ville,
        String telephone,
        List<CompteDto> comptes
) {
}