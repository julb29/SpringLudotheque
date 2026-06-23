package fr.eni.springludotheque.dal;

import fr.eni.springludotheque.bo.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {
     List<Client> findByNomStartingWith(String nom);

     void deleteById (Integer id);
}

