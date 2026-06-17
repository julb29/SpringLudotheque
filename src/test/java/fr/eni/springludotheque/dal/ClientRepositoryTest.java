package fr.eni.springludotheque.dal;

import fr.eni.springludotheque.bo.Adresse;
import fr.eni.springludotheque.bo.Client;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;
    @Test
    public void testCreationClient() {

        // Arrange
        Adresse adresse1 = new Adresse("rue des mouettes", "Quimper", "29000");
        Adresse adresse2 = new Adresse("rue des chouettes", "Rennes", "35000");

        Client c1 = new Client("DUPOND", "Pierre");
        Client c2 = new Client("DURAND", "Paul");

        c1.setAdresse(adresse1);
        c2.setAdresse(adresse2);

        // Acte
        clientRepository.save(c1);
        clientRepository.save(c2);


        // Assert
        Client clientBD = clientRepository.findById(c1.getId()).get();
        assertThat(clientBD).isNotNull();
        assertThat(clientBD.getNom()).isEqualTo(c1.getNom());
        assertThat(clientBD.getAdresse()).isEqualTo(c1.getAdresse());

    }
}
