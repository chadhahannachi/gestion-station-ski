package tn.esprit.gestionStationDeSki.Service;

import tn.esprit.gestionStationDeSki.Entity.Abonnement;
import tn.esprit.gestionStationDeSki.Entity.Moniteur;

import java.util.List;

public interface MoniteurService {
    Moniteur addMoniteur(Moniteur m);
    Moniteur updateMoniteur(Moniteur m);
    List<Moniteur> getAll();
    Moniteur getById(Long numMoniteur);
    boolean deleteById(Long numMoniteur);

    Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, Long  numCours);
}
