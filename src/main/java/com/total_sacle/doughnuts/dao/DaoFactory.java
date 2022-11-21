package com.total_sacle.doughnuts.dao;

public class DaoFactory {
    private static Employees employeesDao;
    private static Productions productionsDao;
    private static Types typesDao;
    private static Config config = new Config();

    public static Employees getEmployeesDao() {
        if (employeesDao == null) {
            employeesDao = new MySQLEmployeesDao(config);
        }
        return employeesDao;
    }

    public static Productions getProductionsDao() {
        if (productionsDao == null) {
            productionsDao = new MySQLProductionsDao(config);
        }
        return productionsDao;
    }

    public static Types getTypesDao() {
        if (typesDao == null) {
            typesDao = new MySQLTypesDao(config);
        }
        return typesDao;
    }
}

