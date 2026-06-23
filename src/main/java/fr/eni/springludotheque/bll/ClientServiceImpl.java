package fr.eni.springludotheque.bll;

import fr.eni.springludotheque.bo.Adresse;
import fr.eni.springludotheque.bo.Client;
import fr.eni.springludotheque.dal.ClientRepository;
import fr.eni.springludotheque.exceptions.ClientNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> getClientById(Integer id) {
        return clientRepository.findById(id);
    }

    @Override
    public List<Client> findByNomStartingWith(String nom) {
        return clientRepository.findByNomStartingWith(nom );
    }

    @Override
    public Client creationClient(Client client) {
        clientRepository.save(client);
        return client;
    }

    @Override
    public Client updateClient(Integer id, Client client) {
        // 1. On vérifie si le client existe en BDD, sinon on lève l'exception
        Client clientExistant = clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id));

        // 2. On met à jour les champs du client existant avec les nouvelles valeurs reçues
        clientExistant.setNom(client.getNom());
        clientExistant.setPrenom(client.getPrenom());
        clientExistant.setAdresse(client.getAdresse());
        clientExistant.setEmail(client.getEmail());
        clientExistant.setTelephone(client.getTelephone());

        // 3. On sauvegarde le client mis à jour (le .save() va faire un SQL UPDATE car l'ID existe)
        return clientRepository.save(clientExistant);
    }

    @Override
    public Client adresseModifiee(Integer id, Adresse adresse) {
        Optional<Client> clientTrouve = getClientById(id);
        if(clientTrouve.isEmpty()){
            throw new ClientNotFoundException(id);
        }
        // 1. On garde l'ID de l'ancienne adresse en faisant .get()
        if (clientTrouve.get().getAdresse() != null) {
            adresse.setId(clientTrouve.get().getAdresse().getId());
        }

        // 2. On attribue la nouvelle adresse
        clientTrouve.get().setAdresse(adresse);

        // 3. On sauvegarde en BDD avec le repository
        return clientRepository.save(clientTrouve.get());
    }


    @Override
    public void deleteClient(Integer id) {

        clientRepository.deleteById(id);
    }


}







