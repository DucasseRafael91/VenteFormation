package com.venteformation.daos;

import com.venteformation.Entities.Formation_type;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FormationTypeDao implements Dao<Formation_type> {

    private static final String URL = "jdbc:mariadb://localhost:3307/formation";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "";

    @Override
    public void create(Formation_type formationType) {
        // À implémenter plus tard
    }

    @Override
    public void update(Formation_type formationType) {
        // À implémenter plus tard
    }

    @Override
    public void delete(int id) {
        // À implémenter plus tard
    }

    @Override
    public Formation_type findById(int id) {
        // À implémenter plus tard
        return null;
    }

    @Override
    public ArrayList<Formation_type> findAll() {
        ArrayList<Formation_type> types = new ArrayList<>();

        String sql = "SELECT t_nom FROM v_type_formation";

        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                String name = resultSet.getString(1);

                types.add(new Formation_type(name));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return types;
    }

}
