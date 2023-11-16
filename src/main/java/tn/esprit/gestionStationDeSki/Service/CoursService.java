package tn.esprit.gestionStationDeSki.Service;

import tn.esprit.gestionStationDeSki.Entity.Cours;

import java.util.List;

public interface CoursService {
    Cours addCours(Cours c);
    Cours updateCours(Cours c);
    List<Cours> getAll();
    Cours getById(Long id);
    boolean deleteById(Long id);

}
