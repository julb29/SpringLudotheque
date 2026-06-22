package fr.eni.springludotheque.rest;

import java.util.List;
import java.util.Optional;

import fr.eni.springludotheque.bll.ClientService;
import fr.eni.springludotheque.bo.Client;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/clients")
public class ClientRestController {

    private final ClientService clientService;
    public ClientRestController(ClientService clientService) {
        this.clientService = clientService;
    }

// POST
    @PostMapping
    public ResponseEntity<Client> creerClient(@RequestBody Client client) {
        if (client == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        Client nouveauClient = clientService.creationClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).header("Location", "/clients/" + nouveauClient.getId())
                .body(nouveauClient);
    }


}
