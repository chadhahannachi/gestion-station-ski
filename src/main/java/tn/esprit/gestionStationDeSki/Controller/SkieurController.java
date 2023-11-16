package tn.esprit.gestionStationDeSki.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionStationDeSki.Entity.Skieur;
import tn.esprit.gestionStationDeSki.Entity.TypeAbonnement;
import tn.esprit.gestionStationDeSki.Service.SkieurService;

import java.util.List;

@RestController
@RequestMapping("Skieur")
@RequiredArgsConstructor
public class SkieurController {

    private final SkieurService skieurService;

    @GetMapping
    public List<Skieur> getAll() {
        return skieurService.getAll();
    }

    @GetMapping("{id}")
    public Skieur getById(@PathVariable Long id){
        return skieurService.getById(id);
    }

    @PutMapping
    public Skieur updateSkieur(Skieur s) {
        return skieurService.updateSkieur(s);
    }

    @PostMapping
    public Skieur addSkieur(@RequestBody Skieur s) {
        return skieurService.addSkieur(s);
    }

    @PostMapping("{numCours}")
    public Skieur addSkierAndAssignToCourse(Skieur skieur, Long numCours){
        return skieurService.addSkierAndAssignToCourse(skieur, numCours);
    }

    @PutMapping("{numSkieur}/{numPiste}")
    public Skieur assignSkierToPiste(@PathVariable Long numSkieur, @PathVariable Long numPiste){
        return skieurService.assignSkierToPiste(numSkieur, numPiste);
    }

    @GetMapping("{numSkieur}")
    public int getNombreDePistesAffectees(@PathVariable Long numSkieur){
        return skieurService.getNombreDePistesAffectees(numSkieur);
    }

    @GetMapping("{name}")
    public List<Skieur> getSkieurByMoniteurName(@PathVariable String name){
        return skieurService.getSkieurByMoniteurName(name);
    }

    @GetMapping("/skieurs")
    public List<Skieur> retrieveSkieursBySubscriptionType(@RequestParam TypeAbonnement typeAbonnement) {
        return skieurService.retrieveSkiersBySubscriptionType(typeAbonnement);
    }

}
