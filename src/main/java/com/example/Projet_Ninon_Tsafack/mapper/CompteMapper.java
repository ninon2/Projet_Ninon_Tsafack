package com.example.Projet_Ninon_Tsafack.mapper;

import com.example.Projet_Ninon_Tsafack.dto.CompteDto;
import com.example.Projet_Ninon_Tsafack.model.Compte;
import com.example.Projet_Ninon_Tsafack.model.CompteCourant;
import com.example.Projet_Ninon_Tsafack.model.CompteEpargne;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CompteMapper {


    @Mappings({
            @Mapping(target = "typeCompte", expression = "java(compte.getClass().getSimpleName())")
    })
    CompteDto compteToCompteDto(Compte compte);
}
