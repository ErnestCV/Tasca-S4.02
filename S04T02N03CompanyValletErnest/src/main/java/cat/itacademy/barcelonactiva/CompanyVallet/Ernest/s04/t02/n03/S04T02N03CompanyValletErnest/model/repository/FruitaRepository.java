package cat.itacademy.barcelonactiva.CompanyVallet.Ernest.s04.t02.n03.S04T02N03CompanyValletErnest.model.repository;

import cat.itacademy.barcelonactiva.CompanyVallet.Ernest.s04.t02.n03.S04T02N03CompanyValletErnest.model.domain.Fruita;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FruitaRepository extends MongoRepository<Fruita, String> {
}
