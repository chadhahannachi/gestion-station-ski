package tn.esprit.gestionStationDeSki.Repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.gestionStationDeSki.Entity.Inscription;

public interface InscriptionRepository extends CrudRepository<Inscription,Long> {
}
