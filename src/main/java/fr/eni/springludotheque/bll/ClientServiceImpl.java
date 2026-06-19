package fr.eni.springludotheque.bll;

import fr.eni.springludotheque.bo.Client;
import fr.eni.springludotheque.dal.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void creationClient (Client client) {
        clientRepository.save(client);
        }

    @Override
    public void updateClient (Client client) {
        if (clientRepository.findById(client.getId()).orElse(null) == null) {
            throw new RuntimeException(client.getId() + " n'existe pas");
        }
        clientRepository.save(client);
    }


    }




