package com.example.Projet_Ninon_Tsafack.controller;

import com.example.Projet_Ninon_Tsafack.dto.CreateClientDto;
import com.example.Projet_Ninon_Tsafack.dto.UpdateClientDto;
import com.example.Projet_Ninon_Tsafack.model.Client;
import com.example.Projet_Ninon_Tsafack.repository.ClientRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetClients() throws Exception {
        mockMvc.perform(get("/clients"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetClient() throws Exception {
        Client client = new Client("Test", "Client", "123 Street", "12345", "City", "1234567890");
        client = clientRepository.save(client);

        mockMvc.perform(get("/clients/" + client.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom").value("Test"));
    }

    @Test
    void testCreateClient() throws Exception {
        CreateClientDto createClientDto = new CreateClientDto("New", "Client", "456 Avenue", "54321", "Town", "0987654321", true, false);

        mockMvc.perform(post("/clients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createClientDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nom").value("New"));
    }

    @Test
    void testUpdateClient() throws Exception {
        Client client = new Client("Update", "Me", "789 Road", "67890", "Village", "1122334455");
        client = clientRepository.save(client);

        UpdateClientDto updateClientDto = new UpdateClientDto("Updated", "Client", null, null, null, null);

        mockMvc.perform(put("/clients/" + client.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updateClientDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nom").value("Updated"))
                .andExpect(jsonPath("$.prenom").value("Client"));
    }

    @Test
    void testDeleteClient() throws Exception {
        Client client = new Client("Delete", "Me", "101 Lane", "13579", "Metro", "5566778899");
        client = clientRepository.save(client);

        mockMvc.perform(delete("/clients/" + client.getId()))
                .andExpect(status().isNoContent());
    }
}
