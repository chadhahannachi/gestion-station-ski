package tn.esprit.gestionStationDeSki.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.gestionStationDeSki.Entity.Cours;
import tn.esprit.gestionStationDeSki.Entity.Inscription;
import tn.esprit.gestionStationDeSki.Entity.Skieur;
import tn.esprit.gestionStationDeSki.Repository.CoursRepository;
import tn.esprit.gestionStationDeSki.Repository.InscriptionRepository;
import tn.esprit.gestionStationDeSki.Repository.SkieurRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InscriptionServiceImp implements InscriptionService {

    private final InscriptionRepository inscriptionRepository;//injection bel constructeur

    private final SkieurRepository skieurRepository;

    private final CoursRepository coursRepository;
    @Override
    public Inscription addInscription(Inscription i) {
        return inscriptionRepository.save(i);
    }

    @Override
    public Inscription updateInscription(Inscription i) {
        return inscriptionRepository.save(i);
    }

    @Override
    public List<Inscription> getAll() {
        return (List<Inscription>) inscriptionRepository.findAll();
    }

    @Override
    public Inscription getById(Long numInscription) {
        //return inscriptionRepository.findById(id).orElse(null);
        return inscriptionRepository.findById(numInscription).orElseThrow(() -> new IllegalArgumentException("no inscription found with this id" + numInscription));
    }

    @Override
    public boolean deleteById(Long numInscription) {
        inscriptionRepository.deleteById(numInscription);
        return !(inscriptionRepository.existsById(numInscription));
    }

    @Override
    public Inscription addRegistrationAndAssignToSkieur(Long numSkieur, Inscription inscription ){
        Skieur skieur=skieurRepository.findById(numSkieur).orElse(null );
        inscription.setSkieur(skieur);//n7otou objet skieur fi inscription
        return inscriptionRepository.save(inscription);
    }
    @Transactional
    @Override
    public Inscription assignRegistrationToCourse(Long id, Long numRegistration ){
        Cours cours=coursRepository.findById(id).orElse(null );
        Inscription inscription =inscriptionRepository.findById(numRegistration).orElse(null);
        inscription.setCours(cours);
        return inscription;
    }

    /*@Override
    public Inscription addRegistrationAndAssignToSkierAndCourse(Inscription inscription, Long numSkieur, Long numCours);{
        Skieur skieur=skieurRepository.findById(numSkieur).orElse(null );

        inscription.setSkieur(skieur);//n7otou objet skieur fi inscription
        Cours cours=coursRepository.findById(numCours).orElse(null );
        inscription.setCours(cours);
        return inscriptionRepository.save(inscription);
    }*/
}