package fr.eni.springludotheque.bll;

import fr.eni.springludotheque.bo.Adresse;
import fr.eni.springludotheque.bo.Client;
import fr.eni.springludotheque.dal.ClientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class ClientServiceImplTest {

    @Autowired
    private ClientService clientService;
    @Autowired
    private ClientRepository clientRepository;

    @Test
    public void testCreationClient() {
        //Arrange
        Adresse adresse = new Adresse("rue des mouettes", "Quimper", "29000");
        Client client = new Client("DUPOND", "Pierre");

        client.setAdresse(adresse);

        // Act
        clientService.creationClient(client);

        //Assert
        //Optional<Client> clientOptionnal = clientRepository.findById(client.getId());

        Client clientBD = clientRepository.findById(client.getId()).orElse(null);
        Assertions.assertNotNull(clientBD);
        Assertions.assertEquals(client, clientBD);

    }

    @Test
    public void testModificationClient() {

        // Arrange : Créa d'un client c1 avec son adresse aInitiale
        Adresse aInitiale = new Adresse("rue des mouettes", "Quimper", "29000");
        Client c1 = new Client("DUPOND", "Pierre");
        c1.setAdresse(aInitiale);
        clientRepository.save(c1);

        // Nouvelles informations à appliquer aFinale et modif nom et prenom

        Adresse aFinale = new Adresse("rue des chouettes", "Rennes", "35000");
        c1.setNom("MARTIN");
        c1.setPrenom("Jacques");
        c1.setAdresse(aFinale);

        // Act : Appel au ClientService
        clientService.updateClient(c1.getId(), c1);

        // Assort :Vérification que les modifications ont bien été implémentées

        Client clientBD = clientRepository.findById(c1.getId()).orElse(null);
        assertThat(clientBD).isNotNull();
        assertThat(clientBD.getNom()).isEqualTo(c1.getNom());
        assertThat(clientBD.getPrenom()).isEqualTo(c1.getPrenom());
        assertThat(clientBD.getAdresse()).isEqualTo(c1.getAdresse());



    }

    @Test
    public void testModificationAdresse (){

        // Arrange : Créa d'un client c1 avec son adresse aInitiale
        Adresse aInitiale = new Adresse("rue des mouettes", "Quimper", "29000");
        Client c1 = new Client("DUPOND", "Pierre");
        c1.setAdresse(aInitiale);
        clientRepository.save(c1);

        // Nouvelles informations à appliquer aFinale et modif nom et prenom

        c1.getAdresse().setRue("rue des Flûtes");

        // Act : Appel au ClientService
        clientService.updateClient(c1.getId(), c1);

        // Assort :Vérification que les modifications ont bien été implémentées

        Client clientBD = clientRepository.findById(c1.getId()).orElse(null);
        assertThat(clientBD).isNotNull();
        assertThat(clientBD.getAdresse()).isEqualTo(c1.getAdresse());
    }


}
