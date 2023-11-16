package tn.esprit.gestionStationDeSki.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.gestionStationDeSki.Entity.Cours;
import tn.esprit.gestionStationDeSki.Entity.Moniteur;
import tn.esprit.gestionStationDeSki.Repository.CoursRepository;
import tn.esprit.gestionStationDeSki.Repository.MoniteurRepository;

import java.util.List;

@Service
public class MoniteurServiceImp implements MoniteurService{
    @Autowired
    MoniteurRepository moniteurRepository;
    @Autowired
    CoursRepository coursRepository;
    @Override
    public Moniteur addMoniteur(Moniteur m) {
        return moniteurRepository.save(m);
    }

    @Override
    public Moniteur updateMoniteur(Moniteur m) {
        return moniteurRepository.save(m);
    }

    @Override
    public List<Moniteur> getAll() {
        return (List<Moniteur>) moniteurRepository.findAll();
    }

    @Override
    public Moniteur getById(Long numMoniteur) {
        //return moniteurRepository.findById(id).orElse(null);
        return moniteurRepository.findById(numMoniteur).orElseThrow(() -> new IllegalArgumentException("no moniteur found with this id" + numMoniteur));
    }

    @Override
    public boolean deleteById(Long numMoniteur) {
        moniteurRepository.deleteById(numMoniteur);
        return !(moniteurRepository.existsById(numMoniteur));
    }

    @Override
    public Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, Long  numCours){
        Cours cours=coursRepository.findById( numCours).orElse(null );
        moniteur.setCours((List<Cours>) cours);//n7otou objet skieur fi inscription
        return moniteurRepository.save(moniteur);
    }




}