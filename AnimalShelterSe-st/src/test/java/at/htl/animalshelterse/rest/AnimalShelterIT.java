package at.htl.animalshelterse.rest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AnimalShelterIT {
    public static final String DRIVER_STRING = "org.apache.derby.jdbc.ClientDriver";
    static final String CONNECTION_STRING = "jdbc:derby://localhost:1527/db;create=true";
    static final String USER = "app";
    static final String PASSWORD = "app";

    private static Connection connection;

    @BeforeAll
    public static void openConnection(){
        try {
            Class.forName(DRIVER_STRING);
            connection = DriverManager.getConnection(CONNECTION_STRING, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Could not open Connection to database: \n" + e.getMessage());
            System.exit(1);
        }
    }

    @AfterAll
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

    @Test
    public void createTest(){
        try {
            Statement createStmt = connection.createStatement();

            String sql = "CREATE TABLE test_animalSpecies(" +
                    "breed varchar(50) constraint breedPk PRIMARY KEY," +
                    "species varchar(50)," +
                    "genus varchar(50))";

            createStmt.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
