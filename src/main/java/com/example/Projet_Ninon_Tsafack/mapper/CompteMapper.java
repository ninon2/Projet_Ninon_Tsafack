package com.example.Projet_Ninon_Tsafack.mapper;

import com.example.Projet_Ninon_Tsafack.dto.CompteDto;
import com.example.Projet_Ninon_Tsafack.model.Compte;
import com.example.Projet_Ninon_Tsafack.model.CompteCourant;
import com.example.Projet_Ninon_Tsafack.model.CompteEpargne;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CompteMapper {

    // Main delegating method
    default CompteDto compteToCompteDto(Compte compte) {
        if (compte instanceof CompteCourant) {
            return mapCompteCourant((CompteCourant) compte);
        }
        if (compte instanceof CompteEpargne) {
            return mapCompteEpargne((CompteEpargne) compte);
        }
        // Fallback for generic Compte, though in this hierarchy, it might not be reached directly
        CompteDto dto = new CompteDto(compte.getId(), compte.getNumeroCompte(), compte.getSolde(), compte.getDateOuverture(), compte.getClass().getSimpleName(), null, null);
        return dto;
    }

    @Mapping(target = "typeCompte", expression = "java(\"CompteCourant\")")
    @Mapping(target = "decouvertAutorise", source = "decouvertAutorise")
    @Mapping(target = "tauxRemuneration", ignore = true) // Explicitly ignore as it's not a CompteCourant property
    CompteDto mapCompteCourant(CompteCourant compteCourant);

    @Mapping(target = "typeCompte", expression = "java(\"CompteEpargne\")")
    @Mapping(target = "tauxRemuneration", source = "tauxRemuneration")
    @Mapping(target = "decouvertAutorise", ignore = true) // Explicitly ignore as it's not a CompteEpargne property
    CompteDto mapCompteEpargne(CompteEpargne compteEpargne);
}
