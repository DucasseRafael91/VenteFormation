package com.venteformation.daos;

import com.venteformation.entities.formationType;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FormationTypeDao implements Dao<formationType> {

    private static final String URL = "jdbc:mariadb://localhost:3307/formation";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "";

    @Override
    public void create(formationType formationType) {
        // À implémenter plus tard
    }

    @Override
    public void update(formationType formationType) {
        // À implémenter plus tard
    }

    @Override
    public void delete(int id) {
        // À implémenter plus tard
    }

    @Override
    public formationType findById(int id) {
        // À implémenter plus tard
        return null;
    }

    @Override
    public ArrayList<formationType> findAll() {
        ArrayList<formationType> types = new ArrayList<>();

        String sql = "SELECT t_nom FROM v_type_formation";

        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                String name = resultSet.getString(1);

                types.add(new formationType(name));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return types;
    }

}
