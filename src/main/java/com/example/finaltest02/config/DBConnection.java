package com.example.finaltest02.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static DBConnection instance = null;
    private Connection conn = null;

    public DBConnection() {}

    private void init() throws SQLException {

        DatabaseProperties dbProps = new DatabaseProperties();

        try {
            Class.forName(dbProps.getDriver());
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
            return;
        }

        final String DB_URL = dbProps.getUrl();
        final String USER = dbProps.getUsername();
        final String PASS = dbProps.getPassword();

        conn = DriverManager.getConnection(DB_URL, USER, PASS);

        if (conn != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }
    }

    public Connection getConnection() {
        return conn;
    }

    public static DBConnection getInstance() throws SQLException {
        if (instance != null && !instance.getConnection().isClosed()) {
            return instance;
        } else {
            instance = new DBConnection();
            instance.init();
            return instance;
        }
    }
}


