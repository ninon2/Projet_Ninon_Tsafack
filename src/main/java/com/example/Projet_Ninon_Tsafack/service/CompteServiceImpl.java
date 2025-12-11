package com.example.Projet_Ninon_Tsafack.service;

import com.example.Projet_Ninon_Tsafack.dto.CompteDto;
import com.example.Projet_Ninon_Tsafack.exceptions.ResourceNotFoundException;
import com.example.Projet_Ninon_Tsafack.mapper.CompteMapper;
import com.example.Projet_Ninon_Tsafack.model.Compte;
import com.example.Projet_Ninon_Tsafack.repository.CompteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompteServiceImpl implements CompteService {

    private final CompteRepository compteRepository;
    private final CompteMapper compteMapper;

    public CompteServiceImpl(CompteRepository compteRepository, CompteMapper compteMapper) {
        this.compteRepository = compteRepository;
        this.compteMapper = compteMapper;
    }

    @Override
    public List<CompteDto> getAllComptes() {
        List<Compte> comptes = compteRepository.findAll();
        return comptes.stream().map(compteMapper::compteToCompteDto).collect(Collectors.toList());
    }

    @Override
    public CompteDto getCompteById(Long compteId) {
        Compte compte = compteRepository.findById(compteId)
                .orElseThrow(() -> new ResourceNotFoundException("Compte not found with id: " + compteId));
        return compteMapper.compteToCompteDto(compte);
    }
}
