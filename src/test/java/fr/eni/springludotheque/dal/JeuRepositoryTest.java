package fr.eni.springludotheque.dal;

import fr.eni.springludotheque.bo.Genre;
import fr.eni.springludotheque.bo.Jeu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class JeuRepositoryTest {

    @Autowired
    private JeuRepository jeuRepository;

    @Test
    @DisplayName("test création jeu et liens vers genres CAS POSITIF")
    public void testCreationJeu() {

        // Arrange
        Jeu j1 = new Jeu("1234567891011", "Tetris", 12.5d);
        Jeu j2 = new Jeu("1234567891012", "Super Mario", 20d);

        j1.addGenre(new Genre(3));
        j1.addGenre(new Genre(4));
        //j2.addGenre(new Genre(4));

        // Acte
        jeuRepository.save(j1);
        jeuRepository.save(j2);

        // Assert
        Jeu jeuBD = jeuRepository.findById(j1.getId()).get();
        assertThat(jeuBD).isNotNull();
        assertThat(jeuBD.getTitre()).isEqualTo(j1.getTitre());
        assertThat(jeuBD.getTarif()).isEqualTo(j1.getTarif());
        assertThat(jeuBD.getGenres().size()).isEqualTo(2);

    }



}
