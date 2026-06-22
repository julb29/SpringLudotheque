package fr.eni.springludotheque.dal;

import fr.eni.springludotheque.bo.Jeu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JeuRepository extends JpaRepository<Jeu, Integer> {
    List<Jeu> findByTitre (String titre);
    // Si l'attribut dans Genre s'appelle "libelle"
    List<Jeu> findByGenres_Libelle(String libelle);
}
