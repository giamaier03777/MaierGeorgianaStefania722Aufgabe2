package src.Controller;

import src.Domain.Charakter;
import src.Domain.Produkt;
import src.Repository.CharakterRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Controller class for managing customers and their associated products.
 */

public class CharakterController {
    private CharakterRepo repo;

    /**
     * Constructs a new KundenController with the specified repository.
     *
     * @param repo the customer repository to manage
     */
    public CharakterController(CharakterRepo repo) {
        this.repo = repo;
    }

    /**
     * Adds a new customer to the repository.
     *
     * @param id     the ID of the customer
     * @param name   the name of the customer
     * @param region the location of the customer
     */

    public void createCharakter(int id, String name, String region) {
        Charakter charakter = new Charakter(id, name, region);
        repo.addCharakter(charakter);
    }

    /**
     * Removes a customer from the repository by their ID.
     *
     * @param id the ID of the customer to remove
     */
    public void removeCharakter(int id) {
        Charakter charakter = repo.findCharacterbyId(id);
        repo.removeCharakter(charakter);
    }


    public void updateCharakter(int id, String name, String neuerName, String neueRegion) {
        Charakter charakter = repo.findCharacterbyId(id);

        if (charakter != null) {
            if (!charakter.getName().equals(neuerName)) {
                repo.removeCharakter(charakter);
                repo.addCharakter(new Charakter(id, neuerName, neueRegion));
            } else {
                charakter.setName(neuerName);
                charakter.setRegion(neueRegion);
                repo.updateCharakter(charakter);
            }
            System.out.println("Charakter erfolgreich aktualisiert: " + neuerName);
        } else {
            System.out.println("Charakter nicht gefunden!");
        }
    }


    /**
     * Retrieves a customer by their ID.
     *
     * @param id the ID of the customer to retrieve
     * @return the customer with the specified ID, or null if not found
     */
    public Charakter getChaarkter(int id) {
        return repo.findCharacterbyId(id);
    }

    /**
     * Retrieves all customers in the repository.
     *
     * @return a list of all customers
     */
    public List<Charakter> getAlleCharakter() {
        return repo.getCharakterList();
    }
}


