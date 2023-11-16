package tn.esprit.gestionStationDeSki.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long numCours;
    private int niveau;
    private TypeCours typeCours;
    private Support support;
    private Float prix;
    private int creneau;

    @OneToMany(mappedBy = "cours")
    List<Inscription> inscriptions;

    /*@ManyToOne
    Moniteur moniteur;*/
}
