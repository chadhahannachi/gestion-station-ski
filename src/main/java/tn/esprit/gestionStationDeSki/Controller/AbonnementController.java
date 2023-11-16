package tn.esprit.gestionStationDeSki.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionStationDeSki.Entity.Abonnement;
import tn.esprit.gestionStationDeSki.Service.AbonnementService;

import java.util.List;

@RestController
@RequestMapping("Abonnement")
@RequiredArgsConstructor
public class AbonnementController {
    private final AbonnementService abonnementService;

    @GetMapping
    public List<Abonnement> getAll() {

        return abonnementService.getAll();
    }

    @GetMapping("{id}")
    public Abonnement getById(@PathVariable Long id){
        return abonnementService.getById(id);
    }

    @PutMapping
    public Abonnement updateAbonnement(Abonnement a) {

        return abonnementService.updateAbonnement(a);
    }

    @PostMapping
    public Abonnement addAbonnement(@RequestBody Abonnement a) {

        return abonnementService.addAbonnement(a);
    }

}
