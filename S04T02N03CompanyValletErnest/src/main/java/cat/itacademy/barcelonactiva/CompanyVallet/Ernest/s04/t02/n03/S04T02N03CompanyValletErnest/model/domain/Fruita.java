package cat.itacademy.barcelonactiva.CompanyVallet.Ernest.s04.t02.n03.S04T02N03CompanyValletErnest.model.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Document(collection = "fruites")
public class Fruita {
    @Id
    private String id;

    @NotBlank(message = "No ha de ser buit")
    @NotNull(message = "Nom is mandatory")
    private String nom;

    @Min(1)
    private int quantitatQuilos;

    public Fruita() {
    }

    public Fruita(String nom, int quantitatQuilos) {
        this.nom = nom;
        this.quantitatQuilos = quantitatQuilos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantitatQuilos() {
        return quantitatQuilos;
    }

    public void setQuantitatQuilos(int quantitatQuilos) {
        this.quantitatQuilos = quantitatQuilos;
    }

    @Override
    public String toString() {
        return "Fruita{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", quantitatQuilos=" + quantitatQuilos +
                '}';
    }
}
