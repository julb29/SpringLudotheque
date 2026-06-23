package fr.eni.springludotheque.rest;

import fr.eni.springludotheque.bll.ClientService;
import fr.eni.springludotheque.bo.Adresse;
import fr.eni.springludotheque.bo.Client;

import fr.eni.springludotheque.exceptions.ClientNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;


@RestController
@RequestMapping("/clients")
public class ClientRestController {

    private final ClientService clientService;
    public ClientRestController(ClientService clientService) {
        this.clientService = clientService;
    }

    // GET
    // Retourne la liste des clients et le statut http OK
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<Client> getAllClient() {
        List<Client> clients = clientService.getAllClient();
        return clients;
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

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Integer id) {
        try {
            clientService.deleteClient(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (ClientNotFoundException cnf) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found");
        }
    }

    // PUT
    @PutMapping("/{id}")
    public ResponseEntity<?> updateClient(@PathVariable Integer id, @Valid @RequestBody Client client) {
        try {
            Client clientModifie = clientService.updateClient(id, client);
            return ResponseEntity.ok(clientModifie); // Ici c'est un Client, c'est OK
        } catch(ClientNotFoundException enf) {
            // Ici c'est un String, et grâce au "?", Java l'accepte !
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(enf.getMessage());
        }
    }

    // PATCH
    @PatchMapping("/{id}/adresse")
    public ResponseEntity<ApiResponse<Client>> updateClientAdresse(@PathVariable Integer id, @Valid @RequestBody Adresse adresse) {
        try
        {   // 1. On appelle le service en lui passant directement l'objet 'adresse'
            Client clientModifie = clientService.adresseModifiee(id, adresse);
            // 2. On crée une ApiResponse de succès contenant le client
            ApiResponse<Client> response = new ApiResponse<>(true, "Adresse mise à jour avec succès", clientModifie);
            return ResponseEntity.ok(response);
        } catch (ClientNotFoundException e) {
            // 3. En cas d'erreur, on crée une ApiResponse d'échec (data est à null)
            ApiResponse<Client> response = new ApiResponse<>(false, e.getMessage(), null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }



    }

        /*
        @PatchMapping("/{id}/status")
        public ResponseEntity<ApiResponse<Todo>> updateTodoEtat(@PathVariable Integer id, @RequestBody Todo  todo) {
            try {
                Todo updatedTodo = todoService.updateEtat(id, todo.isEtat());
                return ResponseEntity.ok(new ApiResponse<>(true, "Status updated", updatedTodo));
            } catch (TodoNotFoundException e) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(false, e.getMessage(), null));
            }
        }*/


}
