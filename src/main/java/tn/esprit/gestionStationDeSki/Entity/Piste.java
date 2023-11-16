package tn.esprit.gestionStationDeSki.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Piste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long num_piste;
    private String nom_piste;
    @Enumerated (EnumType.STRING)
    private Couleur couleur;
    private int longueur;
    private int pente;

    @ManyToMany
    Set<Skieur> skieurs;

}
