package com.venteformation.Daos;

import com.venteformation.Entities.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDao implements Dao<User> {

    private static final String URL = "jdbc:mariadb://localhost:3322/vente_formation";
    private static final String LOGIN = "formation";
    private static final String PASSWORD = "formation";

    @Override
    public void create(User user) {
        // À implémenter plus tard
    }

    @Override
    public void update(User user) {
        // À implémenter plus tard
    }

    @Override
    public void delete(int id) {
        // À implémenter plus tard
    }

    @Override
    public User findById(int id) {
        // À implémenter plus tard
        return null;
    }

    @Override
    public ArrayList<User> findAll() {
        // À implémenter plus tard
        return null;
    }

}
