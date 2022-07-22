package cat.itacademy.barcelonactiva.CompanyVallet.Ernest.s04.t02.n02.S04T02N02CompanyValletErnest.model.domain;

import java.io.Serializable;

public class FruitaDTO implements Serializable {

    //No s'està fent servir de moment

    private int id;
    private String nom;
    private int quantitatQuilos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
