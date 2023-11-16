package tn.esprit.gestionStationDeSki.Service;

import tn.esprit.gestionStationDeSki.Entity.Abonnement;
import tn.esprit.gestionStationDeSki.Entity.Skieur;
import tn.esprit.gestionStationDeSki.Entity.TypeAbonnement;

import java.util.List;

public interface SkieurService {
    Skieur addSkieur(Skieur s);
    Skieur updateSkieur(Skieur s);
    List<Skieur> getAll();
    Skieur getById(Long numSkieur);
    boolean deleteById(Long numSkieur);
    Skieur addSkierAndAssignToCourse(Skieur skieur, Long numCours);
    Skieur assignSkierToPiste(Long numSkieur, Long numPiste);

    int getNombreDePistesAffectees(Long numSkieur);

    List<Skieur> getSkieurByMoniteurName(String name);

    List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement);
}
