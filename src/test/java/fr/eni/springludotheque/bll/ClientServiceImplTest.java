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
}
