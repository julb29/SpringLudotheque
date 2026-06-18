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
public class Jeu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    private String reference;

    @NonNull
    private String titre;

    private int age;

    private String description;

    private int duree;

    @NonNull
    private Double tarif;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
            name = "jeux_genres",
            joinColumns = @JoinColumn(name = "id_jeu"),
            inverseJoinColumns = @JoinColumn(name = "id_genre"))
    List<Genre> genres = new ArrayList<>();


    public void addGenre(Genre g) {
        genres.add(g);
    }
}
