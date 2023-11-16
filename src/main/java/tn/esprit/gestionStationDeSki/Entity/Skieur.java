package tn.esprit.gestionStationDeSki.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Skieur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    long numSkieur;
    String nomS;
    String prenomS;
    LocalDate dateNaissance;
    String ville;

    @ManyToMany(mappedBy = "skieurs")
    Set <Piste> pistes;

    @OneToOne(cascade = CascadeType.ALL)
    private Abonnement abonnements;

    @JsonIgnore
    @OneToMany(mappedBy = "skieur")
    List <Inscription> inscriptions;


}
