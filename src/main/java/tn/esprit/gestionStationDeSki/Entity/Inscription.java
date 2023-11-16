package tn.esprit.gestionStationDeSki.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long numInscription;
    private int numSemaine;

    @ManyToOne
    Skieur skieur;

    @ManyToOne
    Cours cours;

    @ManyToOne
    Abonnement Abonnement;


}
