package com.example.Projet_Ninon_Tsafack.service;
import com.example.Projet_Ninon_Tsafack.model.Client;
import com.example.Projet_Ninon_Tsafack.repository.ClientRepository;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repo;

    public ClientServiceImpl(ClientRepository repo) {
        this.repo = repo;
    }

    @PostConstruct
    private void initDb() {
        repo.saveAll(List.of(
                new Client("Madeleine", "Ford", "Adresse 1", "75000", "Paris", "0600000000"),
                new Client("Laura", "Pats", "Adresse 2", "69000", "Lyon", "0611111111")
        ));
    }

    @Override
    public List<Client> getClients() {
        return repo.findAll();
    }

    @Override
    public Client create(Client c) {
        return repo.save(c);
    }

    @Override
    public Optional<Client> getClient(Long id) {
        return repo.findById(id);
    }

    @Override
    public Optional<Client> update(Client c) {
        if (repo.existsById(c.getId())) {
            return Optional.of(repo.save(c));
        }
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}

