package com.venteformation.Daos;

import com.venteformation.Entities.Category;
import com.venteformation.Entities.Formation;

import java.sql.*;
import java.util.ArrayList;

public class FormationDao implements Dao<Formation> {

    private static final String URL = "jdbc:mariadb://localhost:3307/formation";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "";

    @Override
    public void create(Formation user) {
        // À implémenter plus tard
    }

    @Override
    public void update(Formation user) {
        // À implémenter plus tard
    }

    @Override
    public void delete(int id) {
        // À implémenter plus tard
    }

    @Override
    public Formation findById(int id) {
        // À implémenter plus tard
        return null;
    }

    @Override
    public ArrayList<Formation> findAll() {
        ArrayList<Formation> formations = new ArrayList<>();

        String sql = "SELECT * FROM v_formation";

        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                int idUser = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String description = resultSet.getString(3);
                Integer days_amount = resultSet.getInt(4);
                Double price = resultSet.getDouble(5);

                Category category = new Category("Anglais");

                formations.add(new Formation(name, description, days_amount, price, category));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return formations;
    }
}
