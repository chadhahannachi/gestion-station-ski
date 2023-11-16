package tn.esprit.gestionStationDeSki.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tn.esprit.gestionStationDeSki.Entity.*;

import java.util.List;

public interface SkieurRepository extends CrudRepository<Skieur,Long> {
    //List<Skieur> findByAbonnementsTypeAbon(TypeAbonnement typeAbon);
    List <Skieur> findByAbonnementsTypeAbonAndPistesCouleurAndInscriptionCoursSupportAndInscriptionCoursTypeCours(TypeAbonnement typeAbon, Couleur couleurpiste, Support support, TypeCours typeCours );
    List <Skieur> getSkieurByMoniteurName(String nomM);

    @Query(value = "SELECT * " +
            "FROM skieur s " +
            "JOIN inscription i ON s.num_skieur = i.skieur_num_skieur " +
            "JOIN moniteur_cours mc ON i.cours_num_cours = mc.cours_num_cours" +
            " JOIN moniteur m ON m.num_moniteur = mc.moniteur_num_moniteur" +
            " WHERE m.nomm =:name", nativeQuery = true)
    List<Skieur> getSkieurByMoniteurNameSql(@Param("name") String name);

    @Query(value = "SELECT s "+
    "FROM Skieur s "+
    "JOIN Inscription i on i.skieur = s " +
    "JOIN Moniteur m on i.cours member m.cours"+
    " WHERE m.nomM = :name ")
    List<Skieur> getSkieurByMoniteurNameJpql(@Param("name")String name);



//exception
    //nb de piste affectés au skieur

    @Query(value = "SELECT COUNT(*) " +
            "FROM skieur s " +
            "JOIN piste p " +
            "WHERE s.numSkieur = :numSkieur ", nativeQuery = true)
    int countPistesAffectees(@Param("numSkieur") Long numSkieur);
    //SELECT COUNT(*) FROM skieur s JOIN piste p WHERE s.num_skieur = 1


    List<Skieur> findByAbonnementsTypeAbonnement(TypeAbonnement typeAbonnement);
}
