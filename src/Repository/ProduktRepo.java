package src.Repository;


import src.Controller.ProduktController;
import src.Domain.Produkt;

import java.util.ArrayList;
import java.util.List;

public class ProduktRepo {
    private List<Produkt> produktList;

    public ProduktRepo() {
        produktList = new ArrayList<>();
    }

    public void addProdukt(Produkt produkt) {
        produktList.add(produkt);
    }

    public void removeProdukt(Produkt produkt) {
        produktList.remove(produkt);
    }

    public List<Produkt> getAllProdukt() {
        return produktList;
    }

    public void updateProdukt(Produkt produkt) {
        produktList.remove(produkt);
        produktList.add(produkt);
    }

    public Produkt findProduktByName(String name) {
        for (Produkt produkt : produktList) {
            if (produkt.getName().equals(name)) {
                return produkt;
            }
        }
        return null;
    }
}


