package com.example.Projet_Ninon_Tsafack.service;

import com.example.Projet_Ninon_Tsafack.dto.ClientDto;
import com.example.Projet_Ninon_Tsafack.dto.CreateClientDto;
import com.example.Projet_Ninon_Tsafack.dto.UpdateClientDto;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    List<ClientDto> getClients();

    ClientDto create(CreateClientDto c);

    ClientDto getClient(Long id);

    ClientDto update(Long id, UpdateClientDto c);

    void delete(Long id);
}
