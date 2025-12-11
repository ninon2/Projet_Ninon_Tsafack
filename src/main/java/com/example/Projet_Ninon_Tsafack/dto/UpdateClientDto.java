package com.example.Projet_Ninon_Tsafack.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateClientDto(
        @NotBlank(message = "Le nom ne peut pas être vide")
        String nom,
        @NotBlank(message = "Le prénom ne peut pas être vide")
        String prenom,
        String adresse,
        String codePostal,
        String ville,
        @Size(min = 10, max = 10, message = "Le numéro de téléphone doit contenir 10 chiffres")
        String telephone
) {
}
