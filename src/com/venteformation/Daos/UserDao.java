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

    private static final String URL = "jdbc:mariadb://localhost:3307/formation";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "";

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
        ArrayList<User> users = new ArrayList<>();

        String sql = "SELECT * FROM v_utilisateur";

        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                int idUser = resultSet.getInt(1);
                String login = resultSet.getString(2);
                String password = resultSet.getString(3);

                users.add(new User(login, password));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

}
