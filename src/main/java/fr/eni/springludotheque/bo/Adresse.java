package fr.eni.springludotheque.bo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

    @Entity
    @Data
    @NoArgsConstructor
    @RequiredArgsConstructor
    public class Adresse {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @NonNull
        private String rue;

        @NonNull
        private String ville;

        @NonNull
        private String codePostal;
}
