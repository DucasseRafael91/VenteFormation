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

            String choix = scanner.next();

            if (choix == "o") {
                System.out.println("Au revoir !");
                break; 

            } else if (choix == "n") {

                ArrayList<Formation> formations = dao.findAll();
                for (Formation formation : formations) {
                    System.out.println(formation);
                }

            } else {
                System.out.println("Choix invalide, veuillez réessayer.");
            }
        }

        scanner.close();
    }
}
