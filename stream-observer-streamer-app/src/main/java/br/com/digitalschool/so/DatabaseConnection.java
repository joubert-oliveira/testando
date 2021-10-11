package br.com.digitalschool.so;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection connection;

    private DatabaseConnection() {}

    private static Properties getProperties() {
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("./properties/database.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public Connection getConnection() {
        Properties properties = getProperties();

        if (connection == null) {
            try {
                connection = DriverManager.getConnection(
                        properties.getProperty("database.url"),
                        properties.getProperty("database.username"),
                        properties.getProperty("database.password")
                );
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }

        return connection;
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) instance = new DatabaseConnection();
        return instance;
    }
}
