package src.Domain;

import java.util.ArrayList;
import java.util.List;


public class Charakter {
    private int id;
    private String name;
    private String region;
    private List<Produkt> produkteListe;

    /**
     * Constructs a new Charakter object with the specified parameters.
     *
     * @param id   the id of the character
     * @param name the name of the character
     * @param region  the region of the character
     */
    public Charakter(int id, String name, String region) {
        this.id = id;
        this.name = name;
        this.region = region;
        this.produkteListe= new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public List<Produkt> getProdukteListe() {
        return produkteListe;
    }

    public void setProdukteListe(List<Produkt> produkteListe) {
        this.produkteListe = produkteListe;
    }

    public void addProdukt(Produkt produkt) {
        produkteListe.add(produkt);
    }

    public void removeProdukt(Produkt produkt) {
        produkteListe.remove(produkt);
    }

    @Override
    public String toString() {
        return "Charakter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", produkteListe=" + produkteListe +
                '}';
    }
}

