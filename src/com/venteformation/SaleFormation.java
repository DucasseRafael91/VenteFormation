package com.venteformation;

import com.venteformation.Daos.UserDao;
import com.venteformation.Entities.User;

import java.util.ArrayList;

public class SaleFormation {

    public static void main(String[] args) {

        UserDao dao = new UserDao();
        ArrayList<User> users = dao.findAll();

        for (User user : users) {
            System.out.println(user.getLogin());
        }
    }
}
