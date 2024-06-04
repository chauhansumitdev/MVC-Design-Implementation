package com.example.model;

import java.sql.*;

public class JDBC {
    public void executeQuery(String username, String userpassword) {
        System.out.println("Logging entry to main ...");

        String url = "jdbc:postgresql://dpg-cpaeo3sf7o1s73afs4m0-a.singapore-postgres.render.com:5432/jdbc_rsfc";
        String password = "KDnI9UiC5AJQy29LaQAz8yMaF1Gbopjz";
        String user = "jdbc";

        try {
            Class.forName("org.postgresql.Driver");

            try (Connection connection = DriverManager.getConnection(url, user, password)) {

                String query = "INSERT INTO users (username, password) VALUES (?, ?)";

                try (PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.setString(1, username);
                    statement.setString(2, userpassword);

                    int resultSet = statement.executeUpdate();
                    System.out.println(resultSet);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
