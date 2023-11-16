package tn.esprit.gestionStationDeSki.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.gestionStationDeSki.Entity.Piste;
import tn.esprit.gestionStationDeSki.Repository.PisteRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PisteServiceImp implements PisteService{
    //@Autowired
    private final PisteRepository pisteRepository;
    @Override
    public Piste addPiste(Piste p) {
        return pisteRepository.save(p);
    }

    @Override
    public Piste updatePiste(Piste p) {
        return pisteRepository.save(p);
    }

    @Override
    public List<Piste> getAll() {
        log.info("Bonjour");
        return (List<Piste>) pisteRepository.findAll();
    }

    @Override
    public Piste getById(Long num_piste) {
        //return pisteRepository.findById(num_piste).orElse(null);
        return pisteRepository.findById(num_piste).orElseThrow(() -> new IllegalArgumentException("no piste found with this id" + num_piste));
    }

    @Override
    public boolean deleteById(Long num_piste) {
        pisteRepository.deleteById(num_piste);
        return !(pisteRepository.existsById(num_piste));
    }
}
