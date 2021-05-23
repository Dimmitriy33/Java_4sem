package com.shalunov.lab9.login.dao;

import java.sql.*;
import java.util.Properties;

public class Connector {
    private Connection connection;

    public static Connection getConnection() {
        String url = "jdbc:mysql://Dimasik:Igritt2002@localhost:3306/java?allowPublicKeyRetrieval=true&useSSL=false"; //d
        Properties info = new Properties();
        info.put("user", "Dimasik"); //d
        info.put("password", "Igritt2002"); //d
        info.put("useSSL", false);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException("Can't find appropriate database driver", ex);
        }
    }

    public PreparedStatement getPreparedStatement(String sql) {
        try {
            connection = getConnection();
            return connection.prepareStatement(sql);
        } catch (SQLException ex) {
            throw new RuntimeException("Error creating prepared statement", ex);
        }
    }

    public Statement getStatement() {
        try {
            connection = getConnection();
            return connection.createStatement();
        } catch (SQLException ex) {
            throw new RuntimeException("Error creating statement", ex);
        }
    }

    public void close() {
        if (connection != null) {
            try {
                connection.close();
                Thread.sleep(100);

            } catch (SQLException | InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

}