package com.example.Projet_Ninon_Tsafack.service;
import com.example.Projet_Ninon_Tsafack.model.Client;
import java.util.List;
import java.util.Optional;

public interface ClientService {

    List<Client> getClients();

    Client create(Client c);

    Optional<Client> getClient(Long id);

    Optional<Client> update(Client c);

    void delete(Long id);
}
