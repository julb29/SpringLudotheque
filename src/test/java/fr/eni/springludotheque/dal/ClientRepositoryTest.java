package fr.eni.springludotheque.dal;

import fr.eni.springludotheque.bll.ClientService;
import fr.eni.springludotheque.bo.Adresse;
import fr.eni.springludotheque.bo.Client;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    ClientService clientService;

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
        clientService.updateClient(c1);

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
        clientService.updateClient(c1);

        // Assort :Vérification que les modifications ont bien été implémentées

        Client clientBD = clientRepository.findById(c1.getId()).orElse(null);
        assertThat(clientBD).isNotNull();
        assertThat(clientBD.getAdresse()).isEqualTo(c1.getAdresse());
    }

    @Test
    public void testFindByNomStartingWith() {

        // Arrange
        clientRepository.deleteAll();

        Adresse adresse1 = new Adresse("rue des mouettes", "Quimper", "29000");
        Adresse adresse2 = new Adresse("rue des chouettes", "Rennes", "35000");

        Client c1 = new Client("DUPOND", "Pierre");
        Client c2 = new Client("DURAND", "Paul");

        c1.setAdresse(adresse1);
        c2.setAdresse(adresse2);

        clientRepository.save(c1);
        clientRepository.save(c2);

        // Act

        List<Client> clients = clientRepository.findByNomStartingWith("DU");

        // Assert

        assertThat(clients.size()).isEqualTo(2);
    }
}
