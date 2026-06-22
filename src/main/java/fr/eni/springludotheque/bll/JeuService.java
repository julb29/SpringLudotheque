package fr.eni.springludotheque.bll;

import fr.eni.springludotheque.bo.Jeu;

import java.util.List;

public interface JeuService {
    void creationJeu (Jeu jeu);

    void editListeJeu (Jeu jeu);

    List<Jeu> rechercherParGenre(String libelle);
}
