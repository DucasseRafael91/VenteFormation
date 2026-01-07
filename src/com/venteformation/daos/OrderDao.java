package com.venteformation.daos;

import com.venteformation.Entities.Client;
import com.venteformation.Entities.Formation;
import com.venteformation.Entities.Order;
import com.venteformation.Entities.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class OrderDao implements Dao<Order> {

    private static final String URL = "jdbc:mariadb://localhost:3307/formation";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "";


    public void create(Order order, ArrayList<Formation> formations) {
        String sqlCommande = "INSERT INTO v_commande (c_date, c_fk_client) VALUES (CURRENT_TIMESTAMP, ?)";
        String sqlLigne = "INSERT INTO v_ligne_commande (l_fk_formation, l_fk_commande) VALUES (?, ?)";
        String sqlSelectFormation = "SELECT f_id FROM v_formation WHERE f_nom = ?";

        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD)) {

            connection.setAutoCommit(false);

            try (PreparedStatement psCommande =
                         connection.prepareStatement(sqlCommande, Statement.RETURN_GENERATED_KEYS)) {

                psCommande.setInt(1, order.getClient().getId());
                psCommande.executeUpdate();

                try (ResultSet rs = psCommande.getGeneratedKeys()) {
                    if (rs.next()) {
                        order.setId(rs.getInt(1));
                    }
                }
            }

            try (PreparedStatement psSelectFormation = connection.prepareStatement(sqlSelectFormation);
                 PreparedStatement psLigne = connection.prepareStatement(sqlLigne)) {

                for (Formation f : formations) {

                    psSelectFormation.setString(1, f.getName());
                    try (ResultSet rs = psSelectFormation.executeQuery()) {
                        if (rs.next()) {
                            int formationId = rs.getInt("f_id");

                            psLigne.setInt(1, formationId);
                            psLigne.setInt(2, order.getId());
                            psLigne.executeUpdate();
                        } else {
                            System.out.println("La formation '" + f.getName() + "' n'existe pas en base !");
                        }
                    }
                }
            }

            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void create(Order obj) {

    }

    @Override
    public void update(Order order) {
        // À implémenter plus tard
    }

    @Override
    public void delete(int id) {
        // À implémenter plus tard
    }

    @Override
    public Order findById(int id) {
        // À implémenter plus tard
        return null;
    }

    @Override
    public ArrayList<Order> findAll() {
        return null;
    }


}
