package com.venteformation;

import com.venteformation.Daos.FormationDao;
import com.venteformation.Entities.Formation;

import java.util.ArrayList;
import java.util.Scanner;

public class SaleFormation {

    public static void main(String[] args) {

        FormationDao dao = new FormationDao();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Voulez vous vous connectez ? (o/n)");
            System.out.print("Votre choix : ");

            String choice = scanner.next();

            if (choice.equals("o")) {
                System.out.println("Au revoir !");
                break;

            } else if (choice.equals("n")) {

                boolean exitMenu = false;

                while (!exitMenu) {
                    System.out.println("\n=== Menu Non Connecté ===");
                    System.out.println("1. Afficher toutes les formations");
                    System.out.println("2. Afficher les formations par catégorie");
                    System.out.println("3. Rechercher les formations par mot clé");
                    System.out.println("4. Afficher les formations en présentiel");
                    System.out.println("5. Afficher les formations en distanciel");
                    System.out.println("6. Retour au menu précédent");
                    System.out.print("Votre choix : ");

                    int menuChoice = scanner.nextInt();
                    scanner.nextLine(); // Consommer le retour à la ligne

                    switch (menuChoice) {
                        case 1:
                            System.out.println("Afficher toutes les formations...");
                            ArrayList<Formation> formations = dao.findAll();
                            for (Formation formation : formations) {
                                System.out.println(formation);
                            }
                            break;
                        case 2:
                            System.out.println("Afficher les formations par catégorie...");
                            // TODO: filtrer par catégorie
                            break;
                        case 3:
                            System.out.println("Rechercher les formations par mot clé...");
                            // TODO: filtrer par mot clé
                            break;
                        case 4:
                            System.out.println("Afficher les formations en présentiel...");
                            // TODO: filtrer par présentiel
                            break;
                        case 5:
                            System.out.println("Afficher les formations en distanciel...");
                            // TODO: filtrer par distanciel
                            break;
                        case 6:
                            exitMenu = true; // revenir au menu principal
                            break;
                        default:
                            System.out.println("Choix invalide, veuillez réessayer.");
                    }
                }

            } else {
                System.out.println("Choix invalide, veuillez réessayer.");
            }
        }

        scanner.close();
    }
}
