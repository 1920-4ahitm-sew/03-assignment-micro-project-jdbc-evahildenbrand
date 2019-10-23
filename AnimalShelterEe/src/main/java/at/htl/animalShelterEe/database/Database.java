package at.htl.animalShelterEe.database;

import java.sql.Connection;

public class Database {
    public static final String DRIVER_STRING = "org.apache.derby.jdbc.ClientDriver";
    static final String CONNECTION_STRING = "jdbc:derby://localhost:1527/db";
    static final String USER = "app";
    static final String PASSWORD = "app";

    private static Connection connection;

    public Database() {
    }
}
