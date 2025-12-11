package com.example.Projet_Ninon_Tsafack.controller;

import com.example.Projet_Ninon_Tsafack.dto.CompteDto;
import com.example.Projet_Ninon_Tsafack.service.CompteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/comptes")
public class CompteController {

    private final CompteService compteService;

    public CompteController(CompteService compteService) {
        this.compteService = compteService;
    }

    @GetMapping
    public ResponseEntity<List<CompteDto>> getAllComptes() {
        return ResponseEntity.ok(compteService.getAllComptes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompteDto> getCompteById(@PathVariable(value = "id") Long compteId) {
        return ResponseEntity.ok(compteService.getCompteById(compteId));
    }
}
