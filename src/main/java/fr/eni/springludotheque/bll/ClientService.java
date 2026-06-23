package fr.eni.springludotheque.bll;

import fr.eni.springludotheque.bo.Client;

import java.util.List;

public interface ClientService {

    List<Client> getAllClient();

    Client creationClient(Client client);

    Client updateClient(Integer id, Client client);

    void deleteClient(Integer id);


}
