package com.venteformation.daos;

import com.venteformation.Entities.User;

import java.sql.*;
import java.util.ArrayList;

public class UserDao implements Dao<User> {

    private static final String URL = "jdbc:mariadb://localhost:3307/formation";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "";

    @Override
    public void create(User user) {
        String sql = "INSERT INTO v_utilisateur (u_identifiant, u_mot_de_passe) VALUES (?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Utilisateur ajouté avec succès !");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
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

        String sql = "SELECT u_identifiant, u_mot_de_passe FROM v_utilisateur";

        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                String login = resultSet.getString(2);
                String password = resultSet.getString(3);

                users.add(new User(login, password));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public User connexion(User user) {

        String sql = """
        SELECT u_identifiant, u_mot_de_passe
        FROM v_utilisateur
        WHERE u_identifiant = ? AND u_mot_de_passe = ?
        """;

        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new User(
                        resultSet.getString("u_identifiant"),
                        resultSet.getString("u_mot_de_passe")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


}
