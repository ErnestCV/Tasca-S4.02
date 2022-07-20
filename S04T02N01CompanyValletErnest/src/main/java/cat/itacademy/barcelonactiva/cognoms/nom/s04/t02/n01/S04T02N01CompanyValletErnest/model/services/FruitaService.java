package cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n01.S04T02N01CompanyValletErnest.model.services;

import cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n01.S04T02N01CompanyValletErnest.exceptions.FruitaNotFoundException;
import cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n01.S04T02N01CompanyValletErnest.model.domain.Fruita;
import cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n01.S04T02N01CompanyValletErnest.model.repository.FruitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FruitaService {

    @Autowired
    FruitaRepository fruitaRepository;

    public Fruita add(Fruita fruita) {
        return fruitaRepository.save(new Fruita(fruita.getNom(), fruita.getQuantitatQuilos()));
    }

    public Fruita update(int id, Fruita fruita) throws FruitaNotFoundException {
        Optional<Fruita> fruitaData = fruitaRepository.findById(id);
        if (fruitaData.isPresent()) {
            Fruita _fruita = fruitaData.get();
            _fruita.setNom(fruita.getNom());
            _fruita.setQuantitatQuilos(fruita.getQuantitatQuilos());
            return fruitaRepository.save(_fruita);
        } else {
            throw new FruitaNotFoundException("Fruita not found");
        }
    }

    public boolean delete(int id) throws FruitaNotFoundException {
        Optional<Fruita> fruitaData = fruitaRepository.findById(id);
        if (fruitaData.isPresent()) {
            fruitaRepository.deleteById(id);
            return true;
        } else {
            throw new FruitaNotFoundException("Fruita not found");
        }
    }

    public List<Fruita> getAll() {
        return new ArrayList<>(fruitaRepository.findAll());
    }

    public Fruita getOne(int id) throws FruitaNotFoundException {
        Optional<Fruita> fruitaData = fruitaRepository.findById(id);
        if (fruitaData.isPresent()) {
            return fruitaData.get();
        } else {
            throw new FruitaNotFoundException("Fruita not found");
        }
    }
}