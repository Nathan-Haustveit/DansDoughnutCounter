package com.total_sacle.doughnuts.dao;

import com.mysql.cj.jdbc.Driver;
import com.total_sacle.doughnuts.models.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLProductionsDao implements Productions {
    private Connection connection = null;

    public MySQLProductionsDao(Config config) {
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
    public List<Product> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM doughnut_counter_db.productions");
            ResultSet rs = stmt.executeQuery();
            return createProductFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all productions.", e);
        }
    }

    @Override
    public List<Product> filterByUsername(Long id){
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM doughnut_counter_db.productions WHERE employee_id = ?");
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            return createProductFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all productions.", e);
        }
    }

    public List<Product> createProductFromResults(ResultSet rs) throws SQLException {
        List<Product> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractProduct(rs));
        }
        return ads;
    }

    @Override
    public Long insert(Product product) {
        try {
            String insertQuery = "INSERT INTO doughnut_counter_db.productions(employee_id, type_id, amount, production_date) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, product.getEmployeeId());
            stmt.setLong(2, product.getTypeId());
            stmt.setInt(3, product.getAmount());
            stmt.setString(4, product.getProductionDate());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error adding a new production!", e);
        }
    }

    @Override
    public void update(Product product) {
        try {
            String insertQuery = "UPDATE doughnut_counter_db.productions SET type_id = ?, amount = ?, production_date = ? WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(insertQuery);
            stmt.setLong(1, product.getTypeId());
            stmt.setInt(2, product.getAmount());
            stmt.setString(3, product.getProductionDate());
            stmt.setLong(4, product.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating production!", e);
        }
    }

    @Override
    public void delete(long id) {
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("DELETE FROM doughnut_counter_db.productions WHERE id = ?");
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting production!", e);
        }
    }

    public Product extractProduct(ResultSet rs) throws SQLException {
        return new Product(
                rs.getLong("id"),
                rs.getLong("employee_id"),
                rs.getLong("type_id"),
                rs.getInt("amount"),
                rs.getString("production_date")
        );
    }
}
