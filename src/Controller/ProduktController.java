package src.Controller;


import src.Domain.Produkt;
import src.Repository.ProduktRepo;

import java.util.List;

/**
 * Controller class for managing products.
 */
public class ProduktController {
    private ProduktRepo repo;

    /**
     * Constructs a new ProductController with an empty product list.
     */
    public ProduktController(ProduktRepo repo) {
        this.repo = repo;
    }

    /**
     * Adds a new product to the list.
     *
     * @param name       the name of the product
     * @param preis      the price of the product
     * @param universum  the disease associated with the product
     */
    public void addProdukt(String name, int preis, String universum) {
        Produkt produkt = new Produkt(name, preis, universum);
        repo.addProdukt(produkt);
        System.out.println("Produkt hinzugefügt: " + produkt);
    }

    public void removeProdukt(String name) {
        Produkt produkt = repo.findProduktByName(name);
        if (produkt != null) {
            repo.removeProdukt(repo.findProduktByName(name));
        }
        else {
            System.out.println("Produkt nicht gefunden!");
        }
    }

    /**
     * Updates an existing product in the list.
     *
     * @param name         the name of the product to update
     * @param neuerName    the new name of the product
     * @param neuerPreis   the new price of the product
     * @param neuesUniversum the new universe associated with the product
     */
    public void updateProdukt(String name, String neuerName, int neuerPreis, String neuesUniversum) {
        Produkt produkt = repo.findProduktByName(name);

        if (produkt != null) {
            if (!produkt.getName().equals(neuerName)) {
                repo.removeProdukt(produkt);
                repo.addProdukt(new Produkt(neuerName, neuerPreis, neuesUniversum));
            } else {
                produkt.setName(neuerName);
                produkt.setPreis(neuerPreis);
                produkt.setUniversum(neuesUniversum);
                repo.updateProdukt(produkt);
            }
        } else {
            System.out.println("Produkt nicht gefunden!");
        }
    }


    /**
     * Retrieves a product by its name.
     *
     * @param name the name of the product to retrieve
     * @return the product with the specified name, or null if not found
     */
    public Produkt getProdukt(String name) {
        Produkt produkt = repo.findProduktByName(name);
        if (produkt != null) {
            return repo.findProduktByName(name);
        }
        else {
            System.out.println("Produkt nicht gefunden!");
        }
        return null;
    }

    /**
     * Retrieves a list of all products.
     *
     * @return a new list containing all products
     */
    public List<Produkt> getAlleProdukts() {
        return repo.getAllProdukt();
    }
}

