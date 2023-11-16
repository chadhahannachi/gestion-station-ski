package tn.esprit.gestionStationDeSki.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionStationDeSki.Entity.Moniteur;
import tn.esprit.gestionStationDeSki.Service.MoniteurService;

import java.util.List;

@RestController
@RequestMapping("Moniteur")
@RequiredArgsConstructor
public class MoniteurController {
    private final MoniteurService moniteurService ;

    @GetMapping
    public List<Moniteur> getAll(){
        return moniteurService.getAll();
    }

    @GetMapping("{id}")
    public Moniteur getById(@PathVariable Long id){
        return moniteurService.getById(id);
    }

    @PutMapping
    public Moniteur updateMoniteur(Moniteur m) {
        return moniteurService.updateMoniteur(m);
    }

    @PostMapping
    public Moniteur addMoniteur(@RequestBody Moniteur m) {
        return moniteurService.addMoniteur(m);
    }

    @PostMapping("{numCours}")
    public Moniteur addInstructorAndAssignToCourse(@RequestBody Moniteur moniteur, @PathVariable Long  numCours){
        return moniteurService.addInstructorAndAssignToCourse(moniteur, numCours);
    }

}
