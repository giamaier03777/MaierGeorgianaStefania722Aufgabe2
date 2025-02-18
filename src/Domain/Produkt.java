package src.Domain;

import java.util.ArrayList;
import java.util.List;

public class Produkt {

    private String name;
    private int preis;
    private String universum;

    /**
     * Constructs a new Medikament object with the specified parameters.
     *
     * @param name   the name of the medicine
     * @param preis the price of the medicine
     * @param universum  the disese of the medicine
     */
    public Produkt(String name, int preis, String universum) {
        this.name = name;
        this.preis = preis;
        this.universum = universum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPreis() {
        return preis;
    }

    public void setPreis(int preis) {
        this.preis = preis;
    }

    public String getUniversum() {
        return universum;
    }

    public void setUniversum(String universum) {
        this.universum = universum;
    }

    @Override
    public String toString() {
        return "Produkt{" +
                "name='" + name + '\'' +
                ", preis=" + preis +
                ", universum='" + universum + '\'' +
                '}';
    }
}


