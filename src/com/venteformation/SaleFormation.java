package com.venteformation;

import com.venteformation.Daos.FormationDao;
import com.venteformation.Entities.Formation;

import java.util.ArrayList;

public class SaleFormation {

    public static void main(String[] args) {

        FormationDao dao = new FormationDao();
        ArrayList<Formation> formations = dao.findAll();

        for (Formation formation : formations) {
            System.out.println(formation);
        }
    }
}
