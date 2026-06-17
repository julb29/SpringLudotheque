package fr.eni.springludotheque.dal;

import fr.eni.springludotheque.bo.Genre;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class GenreRepositoryTest {

    @Autowired
    private GenreRepository genreRepository;
    @Test
    public void testCreationGenre() {

        // Arrange
        Genre g1 = new Genre("Jeu de Plateau");
        Genre g2 = new Genre("Jeu de Puzzle");

        // Acte
        genreRepository.save(g1);
        genreRepository.save(g2);

        // Assert
        Genre genreBD = genreRepository.findById(g1.getId().get());
        assertThat(genreBD).isNotNull();




    }
}
