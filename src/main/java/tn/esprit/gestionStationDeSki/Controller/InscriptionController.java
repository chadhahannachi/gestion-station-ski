package tn.esprit.gestionStationDeSki.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionStationDeSki.Entity.Inscription;
import tn.esprit.gestionStationDeSki.Service.InscriptionService;

import java.util.List;

@RestController
@RequestMapping("Inscription")
@RequiredArgsConstructor
public class InscriptionController {
    private final InscriptionService inscriptionService ;

    @PostMapping("{numSkieur}")
    public Inscription addRegistrationAndAssignToSkieur(@PathVariable Long numSkieur, @RequestBody Inscription inscription ){
        return inscriptionService.addRegistrationAndAssignToSkieur(numSkieur, inscription);
    }

    @PutMapping("{id}/{numRegistration}")
    public Inscription assignRegistrationToCourse (@PathVariable Long id, @PathVariable Long numRegistration){
        return inscriptionService.assignRegistrationToCourse(id,numRegistration);
    }

    @GetMapping
    public List<Inscription> getAll() {
        return inscriptionService.getAll();
    }

    @GetMapping("{id}")
    public Inscription getById(@PathVariable Long id){
        return inscriptionService.getById(id);
    }

    @PutMapping
    public Inscription updateInscription(Inscription i) {
        return inscriptionService.updateInscription(i);
    }

/*@PostMapping
   public Skieur addInscription(@RequestBody Inscription i) {
        return inscriptionService.addInscription(i);
    }*/




}
