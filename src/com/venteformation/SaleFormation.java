package com.venteformation;

import com.venteformation.daos.CategoryDao;
import com.venteformation.daos.FormationDao;
import com.venteformation.daos.FormationTypeDao;
import com.venteformation.Entities.Category;
import com.venteformation.Entities.Formation;
import com.venteformation.Entities.Formation_type;

import java.util.ArrayList;
import java.util.Scanner;

public class SaleFormation {

    private static final FormationDao formationDao = new FormationDao();
    private static final CategoryDao categoryDao = new CategoryDao();
    private static final FormationTypeDao formationTypeDao = new FormationTypeDao();

    public static void main(String[] ignoredArgs) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Voulez vous vous connectez ? (o/n)");
            System.out.print("Votre choix : ");

            String choice = scanner.next();

            if (choice.equals("o")) {
                System.out.println("Au revoir !");
                break;

            } else if (choice.equals("n")) {
                printUnconnectedMenu(scanner);
            } else {
                System.out.println("Choix invalide, veuillez réessayer.");
            }
        }

        scanner.close();
    }

    private static void printUnconnectedMenu(Scanner scanner) {
        boolean exitMenu = false;

        while (!exitMenu) {
            System.out.println("\n=== Menu Non Connecté ===");
            System.out.println("1. Afficher toutes les formations");
            System.out.println("2. Afficher les formations par catégorie");
            System.out.println("3. Rechercher les formations par mot clé");
            System.out.println("4. Afficher les formations selon leur type");
            System.out.println("5. Retour au menu précédent");
            System.out.print("Votre choix : ");
            int menuChoice = scanner.nextInt();
            scanner.nextLine();

            switch (menuChoice) {
                case 1 -> printAllFormations();
                case 2 -> printFormationsByCategory(scanner);
                case 3 -> printFormationsByKeyword(scanner);
                case 4 -> printFormationsByType(scanner);
                case 5 -> exitMenu = true;
                default -> System.out.println("Choix invalide, veuillez réessayer.");
            }
        }
    }


    private static void printAllFormations() {
        System.out.println("Afficher toutes les formations...");
        displayFormations(formationDao.findAll());
    }

    private static void printFormationsByCategory(Scanner scanner) {
        System.out.println("Afficher les formations par catégorie...");

        ArrayList<Category> categories = categoryDao.findAll();
        int choice = selectItem(categories, scanner);

        if (choice == -1) return;

        Category selectedCategory = categories.get(choice);
        System.out.println("\nFormations de la catégorie " + selectedCategory.getName() + " :");

        displayFormations(formationDao.findByCategory(selectedCategory));
    }

    private static void printFormationsByType(Scanner scanner) {
        System.out.println("Afficher les formations selon leur type");

        ArrayList<Formation_type> types = formationTypeDao.findAll();
        int choice = selectItem(types, scanner);

        if (choice == -1) return;

        Formation_type selectedType = types.get(choice);
        System.out.println("\nFormations du type " + selectedType.getName() + " :");

        displayFormations(formationDao.findByType(selectedType));
    }

    private static void printFormationsByKeyword(Scanner scanner) {
        System.out.println("Rechercher les formations par mot clé...");
        System.out.print("Entrez un mot clé : ");

        String keyword = scanner.nextLine();
        ArrayList<Formation> results = formationDao.findByKeyword(keyword);

        if (results.isEmpty()) {
            System.out.println("Aucune formation trouvée pour le mot clé \"" + keyword + "\".");
        } else {
            System.out.println("\nFormations contenant le mot clé \"" + keyword + "\" :");
            displayFormations(results);
        }
    }

    private static void displayFormations(ArrayList<Formation> formations) {
        for (Formation formation : formations) {
            System.out.println(formation);
        }
    }

    private static <T> int selectItem(ArrayList<T> items, Scanner scanner) {
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i));
        }

        System.out.print("Votre choix (numéro) : ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice < 1 || choice > items.size()) {
            System.out.println("Choix invalide.");
            return -1;
        }

        return choice - 1;
    }
}
