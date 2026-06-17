package fr.eni.springludotheque;

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

    @Bean
    public CommandLineRunner demo(ClientRepository clientRepository) {
        return (args) -> {

            Client c1 = new Client("DUPOND", "Pierre");
            Client c2 = new Client("DURAND", "Paul");

            clientRepository.save(c1);
            clientRepository.save(c2);

            System.out.println("Liste des clients :");
            System.out.println("-----------------------");
            for (Client c : clientRepository.findAll()) {
                System.out.println(c.toString());
            }
        };
    }

}
