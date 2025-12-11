package com.example.Projet_Ninon_Tsafack.service;

import com.example.Projet_Ninon_Tsafack.dto.ClientDto;
import com.example.Projet_Ninon_Tsafack.dto.CreateClientDto;
import com.example.Projet_Ninon_Tsafack.dto.UpdateClientDto;
import com.example.Projet_Ninon_Tsafack.exceptions.ResourceNotFoundException;
import com.example.Projet_Ninon_Tsafack.mapper.ClientMapper;
import com.example.Projet_Ninon_Tsafack.model.Client;
import com.example.Projet_Ninon_Tsafack.model.CompteCourant;
import com.example.Projet_Ninon_Tsafack.model.CompteEpargne;
import com.example.Projet_Ninon_Tsafack.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public List<ClientDto> getClients() {
        return clientRepository.findAll().stream()
                .map(clientMapper::toDto)
                .toList();
    }

    @Override
    public ClientDto getClient(Long id) {
        return clientRepository.findById(id)
                .map(clientMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found"));
    }

    @Override
    public ClientDto create(CreateClientDto createClientDto) {
        Client client = clientMapper.toEntity(createClientDto);
        client.setComptes(new ArrayList<>());

        if (createClientDto.createCompteCourantDto() != null) {
            CompteCourant compteCourant = new CompteCourant();
            compteCourant.setNumeroCompte(UUID.randomUUID().toString());
            compteCourant.setDateOuverture(new Date());
            compteCourant.setClient(client);
            compteCourant.setSolde(createClientDto.createCompteCourantDto().initialSolde() != null ? createClientDto.createCompteCourantDto().initialSolde() : 0.0);
            compteCourant.setDecouvertAutorise(createClientDto.createCompteCourantDto().decouvertAutorise() != null ? createClientDto.createCompteCourantDto().decouvertAutorise() : 1000.0);
            client.getComptes().add(compteCourant);
        }

        if (createClientDto.createCompteEpargneDto() != null) {
            CompteEpargne compteEpargne = new CompteEpargne();
            compteEpargne.setNumeroCompte(UUID.randomUUID().toString());
            compteEpargne.setDateOuverture(new Date());
            compteEpargne.setClient(client);
            compteEpargne.setSolde(createClientDto.createCompteEpargneDto().initialSolde() != null ? createClientDto.createCompteEpargneDto().initialSolde() : 0.0);
            compteEpargne.setTauxRemuneration(createClientDto.createCompteEpargneDto().tauxRemuneration() != null ? createClientDto.createCompteEpargneDto().tauxRemuneration() : 0.03);
            client.getComptes().add(compteEpargne);
        }

        return clientMapper.toDto(clientRepository.save(client));
    }

    @Override
    public ClientDto update(Long id, UpdateClientDto updateClientDto) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found"));

        clientMapper.updateClientFromDto(updateClientDto, client);

        return clientMapper.toDto(clientRepository.save(client));
    }

    @Override
    public void delete(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new ResourceNotFoundException("Client not found");
        }
        clientRepository.deleteById(id);
    }
}