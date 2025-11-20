package com.example.Projet_Ninon_Tsafack.service;

public interface VirementService {
    void virement(Long sourceId, Long destId, double montant);
}
