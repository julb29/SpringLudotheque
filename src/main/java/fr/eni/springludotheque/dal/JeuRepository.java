package fr.eni.springludotheque.dal;

import fr.eni.springludotheque.bo.Jeu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JeuRepository extends JpaRepository<Jeu, Integer> {
}
