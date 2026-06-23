package fr.eni.springludotheque.bll;

import fr.eni.springludotheque.bo.Jeu;
import fr.eni.springludotheque.dal.JeuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JeuServiceImpl implements JeuService {

    private final JeuRepository jeuRepository;

    @Autowired
    public JeuServiceImpl(JeuRepository jeuRepository) {

        this.jeuRepository = jeuRepository;
    }

    @Override
    public Jeu creationJeu(Jeu jeu) {
        jeuRepository.save(jeu);
        return jeu;
    }

    @Override
    public List<Jeu> getAllJeu() {
        return jeuRepository.findAll();
    }

   /* @Override
    public List<Jeu> rechercherParGenre(String libelle) {
        // Remplace .findByGenresJeu(libelle) par le nouveau nom :
        return jeuRepository.findByGenres_Libelle(libelle);
    }*/

}
