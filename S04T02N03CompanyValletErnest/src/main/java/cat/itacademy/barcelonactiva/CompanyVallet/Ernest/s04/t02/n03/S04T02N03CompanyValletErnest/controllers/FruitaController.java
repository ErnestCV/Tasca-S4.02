package cat.itacademy.barcelonactiva.CompanyVallet.Ernest.s04.t02.n03.S04T02N03CompanyValletErnest.controllers;

import cat.itacademy.barcelonactiva.CompanyVallet.Ernest.s04.t02.n03.S04T02N03CompanyValletErnest.exceptions.ElementNotFoundException;
import cat.itacademy.barcelonactiva.CompanyVallet.Ernest.s04.t02.n03.S04T02N03CompanyValletErnest.model.domain.Fruita;
import cat.itacademy.barcelonactiva.CompanyVallet.Ernest.s04.t02.n03.S04T02N03CompanyValletErnest.model.services.FruitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/fruita")
public class FruitaController {

    @Autowired
    FruitaService fruitaService;

    @PostMapping("/add")
    public ResponseEntity<Fruita> createFruita(@Valid @RequestBody Fruita fruita) {
        return new ResponseEntity<>(fruitaService.add(fruita), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Fruita> updateFruita(@PathVariable("id") String id,@Valid @RequestBody Fruita fruita) throws ElementNotFoundException {
        return new ResponseEntity<>(fruitaService.update(id, fruita), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteFruit(@PathVariable("id") String id) throws ElementNotFoundException {
        fruitaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruita> getFruitaById(@PathVariable("id") String id) throws ElementNotFoundException {
        return new ResponseEntity<>(fruitaService.getOne(id), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruita>> getAllFruits() {
        List<Fruita> fruites = fruitaService.getAll();
        if (fruites.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(fruites, HttpStatus.OK);
    }
}
