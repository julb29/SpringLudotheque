package fr.eni.springludotheque.dal;

import fr.eni.springludotheque.bo.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {

}
