package fr.eni.springludotheque.bll;

import fr.eni.springludotheque.bo.Genre;
import fr.eni.springludotheque.bo.Jeu;
import fr.eni.springludotheque.dal.JeuRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class JeuServiceimplTest {

    @Autowired
    private JeuService jeuService;
    @Autowired
    private JeuRepository jeuRepository;


    @Test
    public void creationJeu() {

        // Arrange
        Jeu jeuTest = new Jeu("3456789012345", "Tomb raider", 20d);
        Genre genreTest = new Genre(1);

        jeuTest.setGenres(List.of(genreTest));

        // Act
        jeuService.creationJeu(jeuTest);

        // Assert (Correction du commentaire au passage !)
        Jeu jeuBD = jeuRepository.findById(jeuTest.getId()).orElse(null);

        // 1. On vérifie que le jeu existe bien en BDD
        Assertions.assertNotNull(jeuBD);

        // 2. On compare les attributs un par un
        Assertions.assertEquals(jeuTest.getTitre(), jeuBD.getTitre());
        Assertions.assertEquals(jeuTest.getTarif(), jeuBD.getTarif());

        // 3. On vérifie les genres associés
        Assertions.assertNotNull(jeuBD.getGenres());
        Assertions.assertEquals(1, jeuBD.getGenres().size()); // On vérifie qu'il y a bien 1 genre
        Assertions.assertEquals(1, jeuBD.getGenres().get(0).getId()); // On vérifie que c'est bien l'ID 1
    }

    /*@Test
    public void editListeJeu() {

        // Arrange
        Jeu j1 = new Jeu(("ref","Tomb raider", 20d);




    }
        */

}


