package com.example.Projet_Ninon_Tsafack.service;

import com.example.Projet_Ninon_Tsafack.dto.CompteDto;

import java.util.List;

public interface CompteService {
    List<CompteDto> getAllComptes();
    CompteDto getCompteById(Long compteId);
}
