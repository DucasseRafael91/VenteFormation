package com.venteformation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ArticleDao implements Dao<Article> {

    private static final String URL = "jdbc:mariadb://localhost:3322/shop";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "6jBUDOSBl4CSx28RRtc1";

    @Override
    public void create(Article article) {
        String sql = "INSERT INTO t_articles (description, brand, unitaryprice) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, article.getDescription());
            ps.setString(2, article.getBrand());
            ps.setDouble(3, article.getPrice());

            int row = ps.executeUpdate();
            if (row == 1) {
                System.out.println("Insertion OK");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Article article) {
        String sql = "UPDATE t_articles SET description=?, brand=?, price=? WHERE id=?";

        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, article.getDescription());
            ps.setString(2, article.getBrand());
            ps.setDouble(3, article.getPrice());
            ps.setInt(4, article.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM t_articles WHERE id=?";

        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Article findById(int id) {
        // À implémenter plus tard
        return null;
    }

    @Override
    public ArrayList<Article> findAll() {

        ArrayList<Article> articles = new ArrayList<>();

        String sql = "SELECT * FROM t_articles";

        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                int idUser = resultSet.getInt(1);
                String description = resultSet.getString(2);
                String brand = resultSet.getString(3);
                double price = resultSet.getDouble(4);

                articles.add(new Article(description, brand, price));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return articles;
    }

}
