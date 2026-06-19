package fr.eni.springludotheque.bll;

import fr.eni.springludotheque.bo.Jeu;
import fr.eni.springludotheque.dal.JeuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JeuServiceImpl implements JeuService {

    private final JeuRepository jeuRepository;

    @Autowired
    public JeuServiceImpl(JeuRepository jeuRepository) {

       this.jeuRepository = jeuRepository;
    }

    @Override
    public void creationJeu(Jeu jeu) {
        jeuRepository.save(jeu);
    }

}
