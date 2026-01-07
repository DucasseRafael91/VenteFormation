package com.venteformation.daos;

import com.venteformation.Entities.Category;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CategoryDao implements Dao<Category> {

    private static final String URL = "jdbc:mariadb://localhost:3307/formation";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "";

    @Override
    public void create(Category category) {
        // À implémenter plus tard
    }

    @Override
    public void update(Category category) {
        // À implémenter plus tard
    }

    @Override
    public void delete(int id) {
        // À implémenter plus tard
    }

    @Override
    public Category findById(int id) {
        // À implémenter plus tard
        return null;
    }

    @Override
    public ArrayList<Category> findAll() {
        ArrayList<Category> categories = new ArrayList<>();

        String sql = "SELECT c_nom FROM v_categorie";

        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                String name = resultSet.getString(1);

                categories.add(new Category(name));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categories;
    }

}

