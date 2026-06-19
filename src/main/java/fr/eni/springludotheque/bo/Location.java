package fr.eni.springludotheque.bo;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    private LocalDate dateSortie;

    private LocalDate dateRetour;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_exemplaire")
    private Exemplaire exemplaire;

}
