package tn.esprit.gestionStationDeSki.Service;

import tn.esprit.gestionStationDeSki.Entity.Piste;

import java.util.List;

public interface PisteService {
    Piste addPiste(Piste p);
    Piste updatePiste(Piste p);
    List<Piste> getAll();
    Piste getById(Long num_piste);
    boolean deleteById(Long num_piste);
}
