package com.venteformation;

import com.venteformation.daos.*;
import com.venteformation.Entities.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class SaleFormation {

    private static final FormationDao formationDao = new FormationDao();
    private static final CategoryDao categoryDao = new CategoryDao();
    private static final FormationTypeDao formationTypeDao = new FormationTypeDao();
    private static final UserDao userDao = new UserDao();
    private static final ClientDao clientDao = new ClientDao();
    private static final OrderDao orderDao = new OrderDao();

    public static void main(String[] ignoredArgs) {
        Scanner scanner = new Scanner(System.in);
        User connectedUser = null;

        while (true) {
            System.out.println("Voulez vous vous connectez ? (o/n)");
            System.out.print("Votre choix : ");

            String choice = scanner.next();

            if (choice.equals("o")) {
                connectedUser = authenticateUser(scanner);
                if (connectedUser != null) {
                    printConnectedMenu(scanner, connectedUser);
                    break;
                }
            } else if (choice.equals("n")) {
                printUnconnectedMenu(scanner);
            } else {
                System.out.println("Choix invalide, veuillez réessayer.");
            }
        }

        scanner.close();
    }

    private static User authenticateUser(Scanner scanner) {
        System.out.print("Login : ");
        String login = scanner.next();

        System.out.print("Mot de passe : ");
        String password = scanner.next();

        User user = new User(login, password);
        User connectedUser = userDao.connexion(user);

        if (connectedUser != null) {
            System.out.println("Connexion réussie.");
            return connectedUser;
        }

        System.out.println("Login ou mot de passe incorrect.");
        return null;
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

    private static void printConnectedMenu(Scanner scanner, User user) {
        boolean exitMenu = false;

        while (!exitMenu) {
            System.out.println("\n=== Menu Connecté ===");
            System.out.println("1. Passer commande");
            System.out.println("2. Afficher toutes les formations");
            System.out.println("3. Afficher les formations par catégorie");
            System.out.println("4. Rechercher les formations par mot clé");
            System.out.println("5. Afficher les formations selon leur type");
            System.out.println("6. Retour au menu précédent");
            System.out.print("Votre choix : ");

            int menuChoice = scanner.nextInt();
            scanner.nextLine();

            switch (menuChoice) {
                case 1 -> passOrder(scanner, user);
                case 2 -> printAllFormations();
                case 3 -> printFormationsByCategory(scanner);
                case 4 -> printFormationsByKeyword(scanner);
                case 5 -> printFormationsByType(scanner);
                case 6 -> exitMenu = true;
                default -> System.out.println("Choix invalide, veuillez réessayer.");
            }
        }
    }

    private static void passOrder(Scanner scanner, User user) {
        ArrayList<Client> clients = clientDao.findByUser(user);

        if (clients.isEmpty()) {
            System.out.println("Aucun client disponible.");
            return;
        }

        System.out.println("\n=== Choisir un client ===");
        int clientChoice = selectItem(clients, scanner);

        if (clientChoice == -1) return;

        Client selectedClient = clients.get(clientChoice);
        System.out.println("Client sélectionné : " + selectedClient + "\n");

        ArrayList<Formation> allFormations = formationDao.findAll();
        ArrayList<Formation> selectedFormations = new ArrayList<>();

        boolean continueSelection = true;
        while (continueSelection) {
            System.out.println("\n=== Choisissez une formation (0 pour terminer) ===");
            for (int i = 0; i < allFormations.size(); i++) {
                System.out.println((i + 1) + ". " + allFormations.get(i));
            }

            System.out.print("Votre choix : ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) {
                continueSelection = false;
            } else if (choice < 0 || choice > allFormations.size()) {
                System.out.println("Choix invalide.");
            } else {
                Formation selectedFormation = allFormations.get(choice - 1);
                if (!selectedFormations.contains(selectedFormation)) {
                    selectedFormations.add(selectedFormation);
                    System.out.println("Formation ajoutée : " + selectedFormation);
                } else {
                    System.out.println("Formation déjà sélectionnée.");
                }
            }
        }

        System.out.println("\n=== Formations commandées pour " + selectedClient + " ===");
        for (Formation formation : selectedFormations) {
            System.out.println(formation);
        }
        Order order = new Order(LocalDateTime.now(),selectedClient);
        orderDao.create(order, selectedFormations);
    }


    private static void printAllFormations() {
        displayFormations(formationDao.findAll());
    }

    private static void printFormationsByCategory(Scanner scanner) {
        ArrayList<Category> categories = categoryDao.findAll();
        int choice = selectItem(categories, scanner);
        if (choice == -1) return;
        displayFormations(formationDao.findByCategory(categories.get(choice)));
    }

    private static void printFormationsByType(Scanner scanner) {
        ArrayList<Formation_type> types = formationTypeDao.findAll();
        int choice = selectItem(types, scanner);
        if (choice == -1) return;
        displayFormations(formationDao.findByType(types.get(choice)));
    }

    private static void printFormationsByKeyword(Scanner scanner) {
        System.out.print("Mot clé : ");
        String keyword = scanner.nextLine();
        ArrayList<Formation> results = formationDao.findByKeyword(keyword);

        if (results.isEmpty()) {
            System.out.println("Aucune formation trouvée.");
        } else {
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

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice < 1 || choice > items.size()) {
            System.out.println("Choix invalide.");
            return -1;
        }

        return choice - 1;
    }
}
