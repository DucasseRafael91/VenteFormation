package com.venteformation;

import com.venteformation.Daos.CategoryDao;
import com.venteformation.Daos.FormationDao;
import com.venteformation.Daos.FormationTypeDao;
import com.venteformation.Entities.Category;
import com.venteformation.Entities.Formation;
import com.venteformation.Entities.Formation_type;

import java.util.ArrayList;
import java.util.Scanner;

public class SaleFormation {

    public static void main(String[] args) {

        FormationDao formationDao = new FormationDao();
        CategoryDao categoryDao = new CategoryDao();
        FormationTypeDao formationTypeDao = new FormationTypeDao();
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
                    System.out.println("4. Afficher les formations selon leur type");
                    System.out.println("5. Retour au menu précédent");
                    System.out.print("Votre choix : ");

                    int menuChoice = scanner.nextInt();
                    scanner.nextLine(); // Consommer le retour à la ligne

                    switch (menuChoice) {
                        case 1:
                            System.out.println("Afficher toutes les formations...");
                            ArrayList<Formation> formations = formationDao.findAll();
                            for (Formation formation : formations) {
                                System.out.println(formation);
                            }
                            break;
                        case 2:
                            System.out.println("Afficher les formations par catégorie...");

                            ArrayList<Category> categories = categoryDao.findAll();

                            // Afficher toutes les catégories avec un numéro
                            for (int i = 0; i < categories.size(); i++) {
                                System.out.println((i + 1) + ". " + categories.get(i).getName());
                            }

                            System.out.print("Choisissez une catégorie (numéro) : ");
                            int categoryChoice = scanner.nextInt();
                            scanner.nextLine(); // consommer le retour à la ligne

                            // Vérifier que le choix est valide
                            if (categoryChoice < 1 || categoryChoice > categories.size()) {
                                System.out.println("Choix de catégorie invalide.");
                                break;
                            }

                            Category selectedCategory = categories.get(categoryChoice - 1);
                            ArrayList<Formation> formationsByCategory = formationDao.findByCategory(selectedCategory);

                            System.out.println("\nFormations de la catégorie " + selectedCategory.getName() + " :");
                            for (Formation formation : formationsByCategory) {
                                System.out.println(formation);
                            }

                            break;
                        case 3:
                            System.out.println("Rechercher les formations par mot clé...");
                            System.out.print("Entrez un mot clé : ");
                            String keyword = scanner.nextLine();

                            ArrayList<Formation> formationsByKeyword = formationDao.findByKeyword(keyword);

                            if (formationsByKeyword.isEmpty()) {
                                System.out.println("Aucune formation trouvée pour le mot clé \"" + keyword + "\".");
                            } else {
                                System.out.println("\nFormations contenant le mot clé \"" + keyword + "\" :");
                                for (Formation formation : formationsByKeyword) {
                                    System.out.println(formation);
                                }
                            }
                            break;
                        case 4:
                            System.out.println("Afficher les formations selon leur type");
                            ArrayList<Formation_type> types = formationTypeDao.findAll();

                            for (int i = 0; i < types.size(); i++) {
                                System.out.println((i + 1) + ". " + types.get(i).getName());
                            }

                            System.out.print("Choisissez un type de formation (numéro) : ");
                            int TypeChoice = scanner.nextInt();
                            scanner.nextLine(); // consommer le retour à la ligne

                            // Vérifier que le choix est valide
                            if (TypeChoice < 1 || TypeChoice > types.size()) {
                                System.out.println("Choix de type invalide.");
                                break;
                            }

                            Formation_type selectedType = types.get(TypeChoice - 1);
                            ArrayList<Formation> formationsByType = formationDao.findByType(selectedType);

                            System.out.println("\nFormations du type " + selectedType.getName() + " :");
                            for (Formation formation : formationsByType) {
                                System.out.println(formation);
                            }

                            break;
                        case 5:
                            exitMenu = true;
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
