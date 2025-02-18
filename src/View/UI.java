package src.View;

import src.Controller.CharakterController;
import src.Controller.ProduktController;
import src.Domain.Produkt;
import src.Domain.Charakter;

import java.util.Scanner;

/**
 * User Interface class for managing patients and medications.
 */
public class UI {
    private final CharakterController charakterController;
    private final ProduktController produktController;
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Constructs a new UI object with the given controllers.
     *
     * @param charakterController  the controller for managing characters
     * @param produktController the controller for managing products
     */
    public UI(CharakterController charakterController, ProduktController produktController) {
        this.charakterController = charakterController;
        this.produktController = produktController;
    }

    /**
     * Starts the user interface, displaying the main menu and handling user input.
     */
    public void start() {
        while (true) {
            zeigeMenü();
            int wahl = scanner.nextInt();
            scanner.nextLine();

            switch (wahl) {
                case 1 -> produktCRUD();
                case 2 -> charakterCRUD();
                case 3 -> charakterNachRegion();
                case 4 -> sortiereProdukteEinesCharaktersNachPreis();
                case 5 -> filterCharakterProdukteByUniversum();
                case 6 -> {
                    System.out.println("Programm beendet.");
                    return;
                }
                default -> System.out.println("Ungültige Wahl!");
            }
        }
    }

    /**
     * Displays the main menu options.
     */
    private static void zeigeMenü() {
        System.out.println("\n--- Hauptmenü ---");
        System.out.println("1. Produkt CRUD");
        System.out.println("2. Charakter CRUD");
        System.out.println("3. Charakter nach Region filtern");
        System.out.println("4. Charakter nach Preis der Produkte filtern");
        System.out.println("5. Produkte eines Charakters sortieren");
        System.out.println("6. Beenden");
        System.out.print("Wahl: ");
    }

    /**
     * Handles CRUD operations for medications.
     */
    private void produktCRUD() {
        while (true) {
            System.out.println("\n--- Produkt-CRUD ---");
            System.out.println("1. Produkt hinzufügen");
            System.out.println("2. Produkt entfernen");
            System.out.println("3. Produkt anzeigen");
            System.out.println("4. Alle Produkte anzeigen");
            System.out.println("5. Produkt aktualisieren");
            System.out.println("6. Zurück");
            System.out.print("Wahl: ");

            int wahl = scanner.nextInt();
            scanner.nextLine();

            switch (wahl) {
                case 1 -> {
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Preis: ");
                    int preis = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Universum: ");
                    String universum = scanner.nextLine();

                    produktController.addProdukt(name, preis, universum);
                }
                case 2 -> {
                    System.out.print("Name des Produktes zum Entfernen: ");
                    String name = scanner.nextLine();
                    produktController.removeProdukt(name);
                }

                case 3 -> {
                    System.out.print("Name des Produktes: ");
                    String name  = scanner.nextLine();
                    System.out.println(produktController.getProdukt(name));
                }
                case 4 -> produktController.getAlleProdukts().forEach(System.out::println);
                case 5 -> {
                    System.out.print("Name des zu aktualisierenden Produktes: ");
                    String name = scanner.nextLine();
                    scanner.nextLine();

                    if (produktController.getProdukt(name) == null) {
                        System.out.println("Produkt nicht gefunden!");
                        return;
                    }

                    System.out.print("Neuer Name: ");
                    String neuerName = scanner.nextLine();
                    System.out.print("Neuer Preis: ");
                    int neuerPreis = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Neue Universum: ");
                    String neuesUniversum = scanner.nextLine();

                    produktController.updateProdukt(name, neuerName, neuerPreis, neuesUniversum);
                    System.out.println("Produkt erfolgreich aktualisiert!");
                }


                case 6 -> {
                    return;
                }
                default -> System.out.println("Ungültige Wahl!");
            }
        }
    }

    /**
     * Handles CRUD operations for patients.
     */
    private void charakterCRUD() {
        while (true) {
            System.out.println("\n--- Charakter-CRUD ---");
            System.out.println("1. Charakter hinzufügen");
            System.out.println("2. Charakter entfernen");
            System.out.println("3. Charakter anzeigen");
            System.out.println("4. Alle Charakters anzeigen");
            System.out.println("5. Charakter aktualisieren");
            System.out.println("6. Products fur einen Charakter hinzufugen");
            System.out.println("7. Products fur einen Charakter entfernen");
            System.out.println("8. Zurück");
            System.out.print("Wahl: ");

            int wahl = scanner.nextInt();
            scanner.nextLine();

            switch (wahl) {
                case 1 -> {
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Region: ");
                    String region = scanner.nextLine();
                    charakterController.createCharakter(id, name, region);
                }
                case 2 -> {
                    System.out.print("ID des Charakters zum Entfernen: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    charakterController.removeCharakter(id);
                }
                case 3 -> {
                    System.out.print("ID des Charakters: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(charakterController.getChaarkter(id));
                }
                case 4 -> charakterController.getAlleCharakter().forEach(System.out::println);
                case 5 -> {
                    System.out.print("ID des zu aktualisierenden Charakter: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    Charakter charakter = charakterController.getChaarkter(id);

                    if (charakter == null) {
                        System.out.println("Charakter nicht gefunden!");
                        return;
                    }

                    System.out.println("Aktueller Name: " + charakter.getName());
                    System.out.print("Neuer Name (leer lassen für gleich): ");
                    String neuerName = scanner.nextLine();
                    if (neuerName.isEmpty()) {
                        neuerName = charakter.getName();
                    }

                    System.out.print("Neue Region (leer lassen für gleich): ");
                    String neueRegion = scanner.nextLine();
                    if (neueRegion.isEmpty()) {
                        neueRegion = charakter.getRegion();
                    }

                    charakterController.updateCharakter(id, charakter.getName(), neuerName, neueRegion);
                    System.out.println("Charakter erfolgreich aktualisiert!");
                }
                case 6 -> {
                    System.out.print("ID des Charakters: ");
                    int charakterId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Name des Produktes: ");
                    String produktName = scanner.nextLine();
                    scanner.nextLine();
                    charakterController.addProduktToCharakter(charakterId, produktController.getProdukt(produktName));
                    System.out.println("Produkt erfolgreich hinzugefügt!");
                }
                case 7 -> {
                    System.out.print("ID des Charakters: ");
                    int charakterId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("ID des Produktes: ");
                    String produktName = scanner.nextLine();
                    scanner.nextLine();
                    charakterController.removeProduktFromCharakter(charakterId, produktController.getProdukt(produktName));
                    System.out.println("Produkt erfolgreich entfernt!");
                }
                case 8 -> {
                    return;
                }
                default -> System.out.println("Ungültige Wahl!");
            }
        }
    }

    /**
     * Filters and displays characters by region.
     */
    private void charakterNachRegion() {
        System.out.print("Region eingeben: ");
        String region = scanner.nextLine();
        System.out.println("Charakter mit Region '" + region + "':");
        charakterController.filterCharakterbyRegion(region).forEach(System.out::println);
    }

    /**
     * Filters and displays characters by universe.
     */
    private void filterCharakterProdukteByUniversum() {
        System.out.print("Universum eingeben: ");
        String universum = scanner.nextLine();
        System.out.println("Charakter mit Produkt für '" + universum + "':");
        charakterController.filterCharakterProdukteByUniversum(universum).forEach(System.out::println);
    }

    /**
     * Sorts and displays medications of a patient by name.
     */
    private void sortiereProdukteEinesCharaktersNachPreis() {
        System.out.print("Charakter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Sortiermodus (true = aufsteigend, false = absteigend): ");
        boolean aufsteigend = scanner.nextBoolean();
        scanner.nextLine();

        System.out.println("Sortierte Produkte:");
        charakterController.sortiereProdukteEinesPatientenNachPreis(id, aufsteigend).forEach(System.out::println);
    }
}
