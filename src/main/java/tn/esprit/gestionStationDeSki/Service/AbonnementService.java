package tn.esprit.gestionStationDeSki.Service;

import tn.esprit.gestionStationDeSki.Entity.Abonnement;

import java.util.List;

public interface AbonnementService {
    Abonnement addAbonnement(Abonnement a);
    Abonnement updateAbonnement(Abonnement a);
    List<Abonnement> getAll();
    Abonnement getById(Long id);
    boolean deleteById(Long id);
}
