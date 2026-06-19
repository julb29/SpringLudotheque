package fr.eni.springludotheque.bll;

import fr.eni.springludotheque.bo.Exemplaire;
import fr.eni.springludotheque.bo.Location;
import fr.eni.springludotheque.dal.ExemplaireRepository;
import fr.eni.springludotheque.dal.LocationRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class LocationServiceImplTest {

    @Autowired
    private LocationService locationService;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private ExemplaireRepository exemplaireRepository;

    @Test
    public void createLocation() {

        // Arrange
        Exemplaire exemplaire1 = new Exemplaire("7612345678901", true);
        exemplaireRepository.save(exemplaire1);


        LocalDate dateSortieTest = LocalDate.of(2025,6,15);
        Location location1 = new Location();

        location1.setDateSortie(dateSortieTest);
        location1.setExemplaire(exemplaire1);

        // Act
        locationService.creationLocation(location1);

        // Act
        Location locationBD = locationRepository.findById(location1.getId()).orElse(null);
        Assertions.assertNotNull(locationBD);
        Assertions.assertEquals(locationBD.getDateSortie(), dateSortieTest);
        Assertions.assertEquals(locationBD.getExemplaire(), exemplaire1);

    }
}
