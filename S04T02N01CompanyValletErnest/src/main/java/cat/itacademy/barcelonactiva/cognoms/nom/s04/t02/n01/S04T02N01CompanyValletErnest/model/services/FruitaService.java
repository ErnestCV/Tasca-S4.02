package cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n01.S04T02N01CompanyValletErnest.model.services;

import cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n01.S04T02N01CompanyValletErnest.exceptions.ElementNotFoundException;
import cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n01.S04T02N01CompanyValletErnest.model.domain.Fruita;
import cat.itacademy.barcelonactiva.cognoms.nom.s04.t02.n01.S04T02N01CompanyValletErnest.model.repository.FruitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FruitaService {

    @Autowired
    FruitaRepository fruitaRepository;

    public Fruita add(Fruita fruita) {
        return fruitaRepository.save(new Fruita(fruita.getNom(), fruita.getQuantitatQuilos()));
    }

    public Fruita update(int id, Fruita fruita) throws ElementNotFoundException {
        Fruita _fruita = getOne(id);
        _fruita.setNom(fruita.getNom());
        _fruita.setQuantitatQuilos(fruita.getQuantitatQuilos());
        return fruitaRepository.save(_fruita);
    }

    public void delete(int id) throws ElementNotFoundException {
        getOne(id);
        fruitaRepository.deleteById(id);
    }

    public List<Fruita> getAll() {
        return new ArrayList<>(fruitaRepository.findAll());
    }

    public Fruita getOne(int id) throws ElementNotFoundException{
        return fruitaRepository.findById(id).orElseThrow(() -> new ElementNotFoundException("No s'ha trobat l'element"));
    }
}