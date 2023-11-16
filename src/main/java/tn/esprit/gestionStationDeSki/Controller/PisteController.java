package tn.esprit.gestionStationDeSki.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionStationDeSki.Entity.Piste;
import tn.esprit.gestionStationDeSki.Service.PisteService;

import java.util.List;

@RestController
@RequestMapping("Piste")
@RequiredArgsConstructor
public class PisteController {
    private final PisteService pisteService;

    @GetMapping
    public List<Piste> getAll(){
        return pisteService.getAll();
    }

    @GetMapping("{id}")
    public Piste getById(@PathVariable Long id){
        return pisteService.getById(id);
    }

    @PutMapping
    public Piste updatePiste(Piste p) {
        return pisteService.updatePiste(p);
    }

    @PostMapping
    public Piste addPiste(@RequestBody Piste p) {
        return pisteService.addPiste(p);
    }
}
