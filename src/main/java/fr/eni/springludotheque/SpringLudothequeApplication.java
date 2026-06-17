package fr.eni.springludotheque;

import fr.eni.springludotheque.bo.Adresse;
import fr.eni.springludotheque.bo.Client;
import fr.eni.springludotheque.dal.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringLudothequeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringLudothequeApplication.class, args);
    }


}
