package fr.eni.springludotheque.bo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    private String nom;

    @NonNull
    private String prenom;

    @Column(unique=true)
    private String email;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch=FetchType.EAGER)
    @JoinColumn(name="id_adresse") // Clé étrangère dans la table Client
    private Adresse adresse;


    private String telephone;


    @Override
    public String toString() {
        return nom + " " + prenom + " " + email + " " + telephone;
    }
}
