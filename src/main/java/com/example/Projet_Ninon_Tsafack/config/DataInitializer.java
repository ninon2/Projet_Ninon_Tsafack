package com.example.Projet_Ninon_Tsafack.config;

import com.example.Projet_Ninon_Tsafack.model.Client;
import com.example.Projet_Ninon_Tsafack.model.CompteCourant;
import com.example.Projet_Ninon_Tsafack.model.CompteEpargne;
import com.example.Projet_Ninon_Tsafack.repository.ClientRepository;
import com.example.Projet_Ninon_Tsafack.repository.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ClientRepository clientRepository;
    private final CompteRepository compteRepository;

    public DataInitializer(ClientRepository clientRepository, CompteRepository compteRepository) {
        this.clientRepository = clientRepository;
        this.compteRepository = compteRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Client 1
        Client client1 = new Client("John", "Doe", "123 Main St", "12345", "CityA", "123-456-7890");
        clientRepository.save(client1);

        CompteCourant cc1 = new CompteCourant();
        cc1.setNumeroCompte(UUID.randomUUID().toString());
        cc1.setSolde(1000.0);
        cc1.setDateOuverture(new Date());
        cc1.setClient(client1);
        compteRepository.save(cc1);

        CompteEpargne ce1 = new CompteEpargne();
        ce1.setNumeroCompte(UUID.randomUUID().toString());
        ce1.setSolde(5000.0);
        ce1.setDateOuverture(new Date());
        ce1.setTauxRemuneration(0.02);
        ce1.setClient(client1);
        compteRepository.save(ce1);

        // Client 2
        Client client2 = new Client("Jane", "Smith", "456 Oak Ave", "54321", "CityB", "987-654-3210");
        clientRepository.save(client2);

        CompteCourant cc2 = new CompteCourant();
        cc2.setNumeroCompte(UUID.randomUUID().toString());
        cc2.setSolde(2000.0);
        cc2.setDateOuverture(new Date());
        cc2.setClient(client2);
        compteRepository.save(cc2);
    }
}