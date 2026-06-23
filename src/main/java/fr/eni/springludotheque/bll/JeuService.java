package fr.eni.springludotheque.bll;

import fr.eni.springludotheque.bo.Jeu;

import java.util.List;

public interface JeuService {
    Jeu creationJeu(Jeu jeu);


    List<Jeu> getAllJeu();



}
