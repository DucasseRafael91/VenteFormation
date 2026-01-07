package com.venteformation.daos;

import com.venteformation.Entities.Category;
import com.venteformation.Entities.Formation;
import com.venteformation.Entities.Formation_type;

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

        String sql = "SELECT f_nom,f_description,duree_jours,prix,c_nom\n" +
                "FROM v_formation\n" +
                "INNER JOIN v_categorie\n" +
                "ON v_formation.f_fk_categorie = v_categorie.c_id\n" +
                "ORDER BY c_nom;";

        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                String name = resultSet.getString(1);
                String description = resultSet.getString(2);
                Integer days_amount = resultSet.getInt(3);
                Double price = resultSet.getDouble(4);

                Category category = new Category(resultSet.getString(5));

                formations.add(new Formation(name, description, days_amount, price, category));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return formations;
    }

    public ArrayList<Formation> findByCategory(Category category) {
        ArrayList<Formation> formations = new ArrayList<>();

        String sql =
                "SELECT f_nom, f_description, duree_jours, prix " +
                        "FROM v_formation f " +
                        "INNER JOIN v_categorie c ON f.f_fk_categorie = c.c_id " +
                        "WHERE c.c_nom = ?";

        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, category.getName());


            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("f_nom");
                String description = resultSet.getString("f_description");
                int days_amount = resultSet.getInt("duree_jours");
                double price = resultSet.getDouble("prix");

                formations.add(new Formation(name, description, days_amount, price, category));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return formations;
    }

    public ArrayList<Formation> findByType(Formation_type type) {
        ArrayList<Formation> formations = new ArrayList<>();

        String sql =
                "SELECT f_nom, f_description, duree_jours, prix, c_nom \n" +
                        "FROM `v_formation` \n" +
                        "INNER JOIN est_de_type\n" +
                        "ON `f_id` = e_fk_formation \n" +
                        "INNER JOIN v_type_formation\n" +
                        "ON t_id = e_fk_type_formation\n" +
                        "INNER JOIN v_categorie\n" +
                        "ON v_formation.f_fk_categorie = v_categorie.c_id\n" +
                        "WHERE t_nom = ?;";

        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, type.getName());

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("f_nom");
                String description = resultSet.getString("f_description");
                int days_amount = resultSet.getInt("duree_jours");
                double price = resultSet.getDouble("prix");

                Category category = new Category(resultSet.getString(5));

                formations.add(new Formation(name, description, days_amount, price, category));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return formations;
    }

    public ArrayList<Formation> findByKeyword(String keyword) {
        ArrayList<Formation> formations = new ArrayList<>();

        String sql =
                "SELECT f.f_nom, f.f_description, f.duree_jours, f.prix, c.c_nom " +
                        "FROM v_formation f " +
                        "INNER JOIN v_categorie c ON f.f_fk_categorie = c.c_id " +
                        "WHERE f.f_nom LIKE ?";

        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, "%" + keyword + "%"); // Le % permet de chercher n'importe où dans le nom

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("f_nom");
                String description = resultSet.getString("f_description");
                int daysAmount = resultSet.getInt("duree_jours");
                double price = resultSet.getDouble("prix");
                Category category = new Category(resultSet.getString("c_nom"));

                formations.add(new Formation(name, description, daysAmount, price, category));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return formations;
    }


}
