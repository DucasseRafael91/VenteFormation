package com.venteformation.daos;

import com.venteformation.Entities.Client;
import com.venteformation.Entities.Order;
import com.venteformation.Entities.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class OrderDao implements Dao<Order> {

    private static final String URL = "jdbc:mariadb://localhost:3307/formation";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "";

    @Override
    public void create(Order order) {
        String sql = "INSERT INTO v_commande (c_date, c_fk_client) VALUES (CURRENT_TIMESTAMP, ?)";

        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, order.getClient().getId());

            int row = ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
