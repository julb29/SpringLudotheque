package fr.eni.springludotheque.bll;

import fr.eni.springludotheque.bo.Adresse;
import fr.eni.springludotheque.bo.Client;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    List<Client> getAllClient();

    Optional<Client> getClientById(Integer id);

    List<Client> findByNomStartingWith(String nom);

    Client creationClient(Client client);

    Client updateClient(Integer id, Client client);

    void deleteClient(Integer id);

    Client adresseModifiee(Integer id, @Valid Adresse adresse);

}
