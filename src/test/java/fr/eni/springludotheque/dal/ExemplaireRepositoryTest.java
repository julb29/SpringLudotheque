package fr.eni.springludotheque.dal;

import fr.eni.springludotheque.bo.Exemplaire;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class ExemplaireRepositoryTest {

    @Autowired
    private ExemplaireRepository exemplaireRepository;

    @Test
    public void testCreationExemplaire(){

        //Arrange

        Exemplaire e1 =  new Exemplaire("7612345678901", true);

        // Acte

        exemplaireRepository.save(e1);

        // Assert
        Exemplaire exemplaireBD = exemplaireRepository.findById(e1.getId()).get();
        assertThat(exemplaireBD).isNotNull();
        assertThat(exemplaireBD.getId()).isEqualTo(e1.getId());
        assertThat(exemplaireBD.getEan()).isEqualTo(e1.getEan());
        assertThat(exemplaireBD.getEtat()).isEqualTo(e1.getEtat());

    }

}
