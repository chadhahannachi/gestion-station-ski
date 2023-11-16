package tn.esprit.gestionStationDeSki.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.gestionStationDeSki.Entity.Cours;
import tn.esprit.gestionStationDeSki.Repository.CoursRepository;

import java.util.List;

@Service
public class CoursServiceImp implements CoursService {
    @Autowired
    CoursRepository coursRepository  ;
    @Override
    public Cours addCours(Cours c) {
        return coursRepository.save(c);
    }

    @Override
    public Cours updateCours(Cours c) {
        return coursRepository.save(c);
    }

    @Override
    public List<Cours> getAll() {
        return (List<Cours>) coursRepository.findAll();
    }

    @Override
    public Cours getById(Long id) {
        //return coursRepository.findById(id).orElse(null);
        return coursRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("no cours found with this id" + id));
    }

    @Override
    public boolean deleteById(Long id) {
        coursRepository.deleteById(id);
        return !(coursRepository.existsById(id));
    }
}
