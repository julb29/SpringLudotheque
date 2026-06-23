package fr.eni.springludotheque.dal;

import fr.eni.springludotheque.bll.LocationService;
import fr.eni.springludotheque.bo.Exemplaire;
import fr.eni.springludotheque.bo.Location;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class LocationRepositoryTest {

    @Autowired
    private LocationService locationService;
    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private ExemplaireRepository exemplaireRepository;

    @Test
    public void testCreationLocation() {
        //Arrange
        Exemplaire e1 =  new Exemplaire("7612345678901",true);
        exemplaireRepository.save(e1);

        LocalDate dateSortie = LocalDate.of(2026,06,22);
        LocalDate dateRetour = LocalDate.now();
        Location l1 = new Location(dateSortie);

        l1.setDateRetour(dateRetour);
        l1.setExemplaire(e1);

        // Act
        locationRepository.save(l1);

        //Assert
        //Optional<Location> locationOptionnal = locationRepository.findById(client.getId());

        Location locationBD = locationRepository.findById(l1.getId()).orElse(null);
        Assertions.assertNotNull(locationBD);
        Assertions.assertEquals(l1, locationBD);

    }

}
