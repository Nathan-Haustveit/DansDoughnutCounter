package com.total_sacle.doughnuts.dao;

import com.mysql.cj.jdbc.Driver;
import com.total_sacle.doughnuts.models.Product;
import com.total_sacle.doughnuts.models.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLTypesDao implements Types {
    private Connection connection;

    public MySQLTypesDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getEmployee(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<Type> all() {
        String query = "SELECT * FROM doughnut_counter_db.types";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            return createTypesFromList(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<Product> findByType(String type) {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM doughnut_counter_db.productions JOIN doughnut_counter_db.types t ON t.id = doughnut_counter_db.productions.type_id WHERE type = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, type);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                products.add(extractInfo(rs));
            }

            return products;
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

   private Type extractType(ResultSet rs) throws SQLException {
        return new Type(rs.getLong("id"), (rs.getString("type")));
   }

    private List<Type> createTypesFromList(ResultSet rs) throws SQLException {
        List<Type> types = new ArrayList<>();
        while (rs.next()) {
            types.add(extractType(rs));
        }
        return types;
    }

    public Product extractInfo(ResultSet rs) throws SQLException {
        return new Product(
                rs.getLong("id"),
                rs.getLong("employee_id"),
                rs.getLong("type_id"),
                rs.getInt("amount"),
                rs.getString("production_date")
        );
    }
}
