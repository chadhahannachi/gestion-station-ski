package tn.esprit.gestionStationDeSki.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.gestionStationDeSki.Entity.Abonnement;
import tn.esprit.gestionStationDeSki.Repository.AbonnementRepository;

import java.util.List;

@Service
public class AbonnementServiceImp implements AbonnementService {
    @Autowired
    AbonnementRepository abonnementRepository  ;
    @Override
    public Abonnement addAbonnement(Abonnement a) {
        return abonnementRepository.save(a);
    }

    @Override
    public Abonnement updateAbonnement(Abonnement a) {
        return abonnementRepository.save(a);
    }

    @Override
    public List<Abonnement> getAll() {
        return (List<Abonnement>) abonnementRepository.findAll();
    }

    @Override
    public Abonnement getById(Long id) {
        //return abonnementRepository.findById(id).orElse(null);
        return abonnementRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("no abonnement found with this id" + id));
    }

    @Override
    public boolean deleteById(Long id) {
        abonnementRepository.deleteById(id);
        return !(abonnementRepository.existsById(id));
    }

}