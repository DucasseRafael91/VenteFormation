package com.venteformation.daos;

import com.venteformation.Entities.Client;
import com.venteformation.Entities.User;

import java.sql.*;
import java.util.ArrayList;

public class ClientDao implements Dao<Client> {

    private static final String URL = "jdbc:mariadb://localhost:3307/formation";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "";

    @Override
    public void create(Client client) {
        // À implémenter plus tard
    }

    @Override
    public void update(Client client) {
        // À implémenter plus tard
    }

    @Override
    public void delete(int id) {
        // À implémenter plus tard
    }

    @Override
    public Client findById(int id) {
        // À implémenter plus tard
        return null;
    }

    @Override
    public ArrayList<Client> findAll() {
        return null;
    }

    public ArrayList<Client> findByUser(User user) {
        ArrayList<Client> clients = new ArrayList<>();

        String sql =
                "SELECT c_nom, c_prenom, c_email, c_adresse, c_telephone " +
                        "FROM v_client " +
                        "INNER JOIN v_utilisateur ON c_fk_utilisateur = u_id " +
                        "WHERE u_identifiant = ?";

        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, user.getLogin());

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String lastName = resultSet.getString(1);
                    String firstName = resultSet.getString(2);
                    String mail = resultSet.getString(3);
                    String address = resultSet.getString(4);
                    String phone = resultSet.getString(5);

                    clients.add(new Client(
                            lastName,
                            firstName,
                            mail,
                            address,
                            phone,
                            user
                    ));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clients;
    }


}
