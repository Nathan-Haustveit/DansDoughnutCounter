package com.total_sacle.doughnuts.dao;

import com.mysql.cj.jdbc.Driver;
import com.total_sacle.doughnuts.models.Employee;

import java.sql.*;
import java.util.List;

import static com.total_sacle.doughnuts.util.Password.hash;

public class MySQLEmployeesDao implements Employees {
    private Connection connection;

    public MySQLEmployeesDao(Config config) {
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
    public List<Employee> all() {
        return null;
    }

    @Override
    public Employee findByUsername(String username) {
        String query = "SELECT * FROM doughnut_counter_db.employees WHERE username = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            return extractEmployee(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding an employee by username", e);
        }
    }

    @Override
    public Long insert(Employee employee) {
        String query = "INSERT INTO doughnut_counter_db.employees(name, username, password) VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getUsername());
            stmt.setString(3, employee.getPassword());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error adding new employee", e);
        }
    }

    @Override
    public void update(Employee employee) {
        try {
            String insertQuery = "UPDATE doughnut_counter_db.employees SET name = ?, username = ?, password = ? WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(insertQuery);

            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getUsername());
            stmt.setString(3, hash(employee.getPassword()));
            stmt.setLong(4, employee.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating employee.", e);
        }
    }

    @Override
    public Employee findEmployeeById(long id) {
        String query = "SELECT * FROM doughnut_counter_db.employees WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                return extractEmployee(rs);
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error searching for employee by id", e);
        }
    }

    private Employee extractEmployee(ResultSet rs) throws SQLException {
        if (! rs.next()) {
            return null;
        }
        return new Employee(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("username"),
                rs.getString("password")
        );
    }
}