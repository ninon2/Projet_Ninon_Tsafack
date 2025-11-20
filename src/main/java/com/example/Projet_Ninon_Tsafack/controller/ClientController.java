package com.example.Projet_Ninon_Tsafack.controller;
import com.example.Projet_Ninon_Tsafack.model.Client;
import com.example.Projet_Ninon_Tsafack.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping("clients")
    public List<Client> getClients() {
        return service.getClients();
    }

    @PostMapping("clients")
    public Client createClient(@RequestBody Client client) {
        return service.create(client);
    }

    @GetMapping("clients/{id}")
    public ResponseEntity<Client> getClient(@PathVariable Long id) {
        return service.getClient(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("clients/update")
    public ResponseEntity<Client> updateClient(@RequestBody Client client) {
        return service.update(client)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("clients/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
