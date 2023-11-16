package tn.esprit.gestionStationDeSki.Service;

import tn.esprit.gestionStationDeSki.Entity.Inscription;

import java.util.List;

public interface InscriptionService {
    Inscription addInscription(Inscription i);
    Inscription updateInscription(Inscription i);
    List<Inscription> getAll();
    Inscription getById(Long numInscription);
    boolean deleteById(Long numInscription);
    Inscription addRegistrationAndAssignToSkieur(Long numSkieur, Inscription inscription );
    Inscription assignRegistrationToCourse(Long id, Long numRegistration );


}
