package tn.esprit.gestionStationDeSki.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.gestionStationDeSki.Entity.Abonnement;
import tn.esprit.gestionStationDeSki.Entity.Cours;

public interface CoursRepository extends CrudRepository<Cours,Long> {
    /*@Query(value = "SELECT *" +
    "FROM cours c"+
    " JOIN moniteur_cours mc ON c.num_cours = mc.cours_num_cours"+
            " JOIN moniteur m ON m.num_moniteur = mc.moniteur_num_moniteur"+
            "WHERE m.nomM = :nameMon", nativeQuery = true)
*/}
