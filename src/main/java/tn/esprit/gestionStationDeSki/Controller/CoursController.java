package tn.esprit.gestionStationDeSki.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionStationDeSki.Entity.Cours;
import tn.esprit.gestionStationDeSki.Entity.Skieur;
import tn.esprit.gestionStationDeSki.Service.CoursService;
import tn.esprit.gestionStationDeSki.Service.SkieurService;

import java.util.List;

@RestController
@RequestMapping("Cours")
@RequiredArgsConstructor
public class CoursController {
    private final CoursService coursService;

    @GetMapping
    public List<Cours> getAll() {
        return coursService.getAll();
    }

    @GetMapping("{id}")
    public Cours getById(@PathVariable Long id){
        return coursService.getById(id);
    }

    @PutMapping
    public Cours updateCours(Cours c) {
        return coursService.updateCours(c);
    }

    @PostMapping
    public Cours addCours(@RequestBody Cours c) {
        return coursService.addCours(c);
    }
}
