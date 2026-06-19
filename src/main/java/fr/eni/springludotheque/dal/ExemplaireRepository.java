package fr.eni.springludotheque.dal;

import fr.eni.springludotheque.bo.Exemplaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExemplaireRepository extends JpaRepository<Exemplaire, Integer> {
}
