package at.htl.animalShelterEe.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public static final String DRIVER_STRING = "org.apache.derby.jdbc.ClientDriver";
    static final String CONNECTION_STRING = "jdbc:derby://localhost:1527/db";
    static final String USER = "app";
    static final String PASSWORD = "app";

    private static Connection connection;

    public Database() {
    }

    public static void openConnection(){
        try {
            Class.forName(DRIVER_STRING);
            connection = DriverManager.getConnection(CONNECTION_STRING, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Could not open Connection to database: \n" + e.getMessage());
        }
    }

    public static void closeConnection(){
        try {
            if(connection != null || connection.isClosed() == false){
                connection.close();
                System.out.println("Closed connection to Database!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
