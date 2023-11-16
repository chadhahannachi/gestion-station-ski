package tn.esprit.gestionStationDeSki.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import tn.esprit.gestionStationDeSki.Entity.*;
import tn.esprit.gestionStationDeSki.Repository.CoursRepository;
import tn.esprit.gestionStationDeSki.Repository.InscriptionRepository;
import tn.esprit.gestionStationDeSki.Repository.PisteRepository;
import tn.esprit.gestionStationDeSki.Repository.SkieurRepository;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SkieurServiceImp implements SkieurService{

    private final SkieurRepository skieurRepository;
    private final CoursRepository coursRepository;
    private final InscriptionRepository inscriptionRepository;
    private final PisteRepository pisteRepository;
    @Override
    public Skieur addSkieur(Skieur s) {
        return skieurRepository.save(s) ;
    }

    @Override
    public Skieur updateSkieur(Skieur s) {
        return skieurRepository.save(s) ;
    }

    @Override
    public List<Skieur> getAll() {
        return (List<Skieur>) skieurRepository.findAll();
    }

    @Override
    public Skieur getById(Long numSkieur) {
        //return skieurRepository.findById(numSkieur).orElse(null);
        return skieurRepository.findById(numSkieur).orElseThrow(() -> new IllegalArgumentException("no skieur found with this id" + numSkieur));
    }

    @Override
    public boolean deleteById(Long numSkieur) {
        skieurRepository.deleteById(numSkieur);
        return !(skieurRepository.existsById(numSkieur));
    }

    @Override
    public Skieur addSkierAndAssignToCourse(Skieur skieur, Long numCours){//skieur objet jdid mahouch managed entity

        //Abonnement abonnement =skieur.getAbonnements();
        //recuperation des objets
        Cours cours=coursRepository.findById(numCours).orElse(null ); //cours howa l managed entity khtr jebtou men coursRepository
        Inscription inscription= skieur.getInscriptions().stream().findFirst().get();

        inscription.setCours(cours);
        inscription.setSkieur(skieur);

        inscriptionRepository.save(inscription);
        skieurRepository.save(skieur);
        return skieur;
    }

    @Transactional
    @Override
    public Skieur assignSkierToPiste(Long numSkieur, Long numPiste){
        Piste piste = pisteRepository.findById(numSkieur).orElse(null);
        Skieur skieur = skieurRepository.findById(numPiste).orElse(null);
        skieur.setPistes((Set<Piste>) piste);
        return skieur;
    }

    public List<Skieur> getSkieurByMoniteurName(String name){
        return skieurRepository.getSkieurByMoniteurNameSql(name);
    }


     public int getNombreDePistesAffectees(Long numSkieur) {
            return skieurRepository.countPistesAffectees(numSkieur);
        }
    /*public int getNombreDePistesAffectees(Long numSkieur) {
        int nombreDePistesAffectees = skieurRepository.countPistesAffectees(numSkieur);

        if (nombreDePistesAffectees < 0) {
            throw new DataAccessException("Impossible de récupérer le nombre de pistes affectées.") {
            };
        }
        return nombreDePistesAffectees;
    }*/

    public List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement) {
        return skieurRepository.findByAbonnementsTypeAbonnement(typeAbonnement);
    }

}
