package com.example.Projet_Ninon_Tsafack.controller;

import com.example.Projet_Ninon_Tsafack.dto.ClientDto;
import com.example.Projet_Ninon_Tsafack.dto.CreateClientDto;
import com.example.Projet_Ninon_Tsafack.dto.UpdateClientDto;
import com.example.Projet_Ninon_Tsafack.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    public ResponseEntity<List<ClientDto>> getClients() {
        return ResponseEntity.ok(clientService.getClients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> getClient(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.getClient(id));
    }

    @PostMapping
    public ResponseEntity<ClientDto> createClient(@RequestBody CreateClientDto createClientDto) {
        return new ResponseEntity<>(clientService.create(createClientDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDto> updateClient(@PathVariable Long id, @RequestBody UpdateClientDto updateClientDto) {
        return ResponseEntity.ok(clientService.update(id, updateClientDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }
}