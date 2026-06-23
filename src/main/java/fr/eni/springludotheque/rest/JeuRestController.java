package fr.eni.springludotheque.rest;

import fr.eni.springludotheque.bll.JeuService;
import fr.eni.springludotheque.bo.Client;
import fr.eni.springludotheque.bo.Jeu;
import fr.eni.springludotheque.dal.ClientRepository;
import fr.eni.springludotheque.dal.JeuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jeux")
public class JeuRestController {

   private final JeuService jeuService;
   public JeuRestController(JeuService jeuService) {

       this.jeuService = jeuService;
   }
    // POST
    @PostMapping
    public ResponseEntity<Jeu> creerJeu(@RequestBody Jeu jeu) {
        if (jeu == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        Jeu nouveauJeu = jeuService.creationJeu(jeu);
        return ResponseEntity.status(HttpStatus.CREATED).header("Location", "/jeux/" + nouveauJeu.getId())
                .body(nouveauJeu);
    }


    // GET
    // Retourne la liste des jeux et le statut http OK
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<Jeu> getAllJeu() {
        List<Jeu> jeux = jeuService.getAllJeu();
        return jeux;
    };



}
