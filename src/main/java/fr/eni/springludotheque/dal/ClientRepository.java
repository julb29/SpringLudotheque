package fr.eni.springludotheque.dal;

import fr.eni.springludotheque.bo.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
