package com.venteformation;

import com.venteformation.Daos.FormationDao;
import com.venteformation.Entities.Formation;

import java.util.ArrayList;
import java.util.Scanner;

public class SaleFormation {

    public static void main(String[] args) {

        FormationDao dao = new FormationDao();
        Scanner scanner = new Scanner(System.in);

        while (true) { // boucle infinie
            System.out.println("\n--- Menu ---");
            System.out.println("1 : Afficher les formations");
            System.out.println("2 : Quitter");
            System.out.print("Votre choix : ");

            int choix = scanner.nextInt();

            if (choix == 1) {
                ArrayList<Formation> formations = dao.findAll();
                for (Formation formation : formations) {
                    System.out.println(formation);
                }
            } else if (choix == 2) {
                System.out.println("Au revoir !");
                break; // quitte la boucle et le programme
            } else {
                System.out.println("Choix invalide, veuillez réessayer.");
            }
        }

        scanner.close();
    }
}
