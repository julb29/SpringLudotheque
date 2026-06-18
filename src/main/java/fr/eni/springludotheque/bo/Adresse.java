package fr.eni.springludotheque.bo;

import jakarta.persistence.*;
import lombok.*;

@Entity
    @Data
    @NoArgsConstructor
    @RequiredArgsConstructor
    public class Adresse {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @EqualsAndHashCode.Exclude // exclut le champ Id de la génération des méthodes equals() et hashCode()
        private Integer id;

        @NonNull
        @Column(length = 100, nullable = false)
        private String rue;

        @NonNull
        @Column(length = 100, nullable = false)
        private String ville;

        @NonNull
        @Column(length = 5, nullable = false)
        private String codePostal;
}
