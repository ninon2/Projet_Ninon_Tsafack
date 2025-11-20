package com.example.Projet_Ninon_Tsafack.service;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import com.example.Projet_Ninon_Tsafack.model.Client;
import com.example.Projet_Ninon_Tsafack.repository.ClientRepository;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
        import static org.mockito.Mockito.*;

public class ClientSetviceImplTest {

    private ClientRepository repo;
    private ClientService service;

    @BeforeEach
    void setup() {
        repo = mock(ClientRepository.class);
        service = new ClientServiceImpl(repo);
    }

    // -----------------------------
    //      TEST CREATE
    // -----------------------------
    @Test
    void testCreateClient() {
        Client client = new Client("Jean", "Dupont", "Adresse", "75000", "Paris", "0102030405");
        when(repo.save(client)).thenReturn(client);

        Client result = service.create(client);

        assertEquals("Jean", result.getNom());
        verify(repo, times(1)).save(client);
    }

    // -----------------------------
    //      TEST GET BY ID
    // -----------------------------
    @Test
    void testGetClient() {
        Client client = new Client("Marie", "Durand", "Rue X", "75010", "Paris", "0606060606");
        client.setId(1L);

        when(repo.findById(1L)).thenReturn(Optional.of(client));

        Optional<Client> result = service.getClient(1L);

        assertTrue(result.isPresent());
        assertEquals("Marie", result.get().getNom());
        verify(repo, times(1)).findById(1L);
    }

    // -----------------------------
    //      TEST GET ALL
    // -----------------------------
    @Test
    void testGetClients() {
        List<Client> clients = List.of(
                new Client("A", "B", "C", "1", "X", "000"),
                new Client("C", "D", "E", "2", "Y", "111")
        );

        when(repo.findAll()).thenReturn(clients);

        List<Client> result = service.getClients();

        assertEquals(2, result.size());
        verify(repo, times(1)).findAll();
    }

    // -----------------------------
    //      TEST UPDATE
    // -----------------------------
    @Test
    void testUpdateClient() {
        Client client = new Client("Jean", "Dupont", "Adresse", "75000", "Paris", "0102030405");
        client.setId(1L);

        when(repo.existsById(1L)).thenReturn(true);
        when(repo.save(client)).thenReturn(client);

        Optional<Client> result = service.update(client);

        assertTrue(result.isPresent());
        assertEquals("Jean", result.get().getNom());
        verify(repo, times(1)).save(client);
    }

    // -----------------------------
    //      TEST DELETE
    // -----------------------------
    @Test
    void testDeleteClient() {
        doNothing().when(repo).deleteById(1L);

        service.delete(1L);

        verify(repo, times(1)).deleteById(1L);
    }
}
