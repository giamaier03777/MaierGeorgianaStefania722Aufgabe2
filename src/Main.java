package src;

import src.Controller.CharakterController;
import src.Controller.ProduktController;
import src.Controller.ProduktController;
import src.Domain.Produkt;
import src.Domain.Charakter;
import src.Repository.ProduktRepo;
import src.Repository.CharakterRepo;
import src.View.UI;

public class Main {
    public static void main(String[] args) {
        CharakterRepo charakterRepo = new CharakterRepo();
        CharakterController charakterController = new CharakterController(charakterRepo);
        ProduktRepo produktRepo = new ProduktRepo();
        ProduktController produktController = new ProduktController(produktRepo);

        produktRepo.addProdukt(new Produkt("Mjolnir", 500, "Asgard"));
        produktRepo.addProdukt(new Produkt("Vibranium-Schild", 700, "Wakanda"));
        produktRepo.addProdukt(new Produkt("Infinity Gauntlet", 10000, "Titan"));
        produktRepo.addProdukt(new Produkt("Web-Shooter", 250, "Terra"));
        produktRepo.addProdukt(new Produkt("Arc-Reaktor", 1500, "Terra"));
        produktRepo.addProdukt(new Produkt("Norn Stones", 1200, "Asgard"));
        produktRepo.addProdukt(new Produkt("Quantum Suit", 3000, "Terra"));
        produktRepo.addProdukt(new Produkt("X-Gene Serum", 850, "X-Mansion"));
        produktRepo.addProdukt(new Produkt("Cosmic Cube", 9000, "Multiverse"));
        produktRepo.addProdukt(new Produkt("Darkhold", 2000, "Multiverse"));



        Charakter c1 = new Charakter(1, "Thor", "Asgard");
        Charakter c2 = new Charakter(2, "Black Panther", "Wakanda");
        Charakter c3 = new Charakter(3, "Iron Man", "Terra");
        Charakter c4 = new Charakter(4, "Spider-Man", "Terra");
        Charakter c5 = new Charakter(5, "Doctor Strange", "Multiverse");


        charakterRepo.addCharakter(c1);
        charakterRepo.addCharakter(c2);
        charakterRepo.addCharakter(c3);
        charakterRepo.addCharakter(c4);
        charakterRepo.addCharakter(c5);

        UI ui = new UI(charakterController, produktController);
        ui.start();
    }
}
