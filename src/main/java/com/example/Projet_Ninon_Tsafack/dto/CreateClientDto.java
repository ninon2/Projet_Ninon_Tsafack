package com.example.Projet_Ninon_Tsafack.dto;

public record CreateClientDto(
        String nom,
        String prenom,
        String adresse,
        String codePostal,
        String ville,
        String telephone,
        CreateCompteCourantDto createCompteCourantDto,
        CreateCompteEpargneDto createCompteEpargneDto
) {
}