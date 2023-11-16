package tn.esprit.gestionStationDeSki.Repository;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.gestionStationDeSki.Entity.Abonnement;
import tn.esprit.gestionStationDeSki.Entity.TypeAbonnement;

import java.time.LocalDate;
import java.util.List;

public interface AbonnementRepository extends CrudRepository<Abonnement,Long>{
    /*List<Abonnement> findAbonnementByTypeAbonOrderBydateDebut(TypeAbonnement typeAbon);
    List<Abonnement> findAbonnementByDateDebutAndDateFin(LocalDate dateDebut, LocalDate dateFin);
*/
}
