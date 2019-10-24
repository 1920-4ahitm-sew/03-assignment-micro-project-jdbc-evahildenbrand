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
            Statement stmt = connection.createStatement();

            String createSql = "CREATE TABLE test_animalSpecies(" +
                    "breed varchar(50) constraint breedPk PRIMARY KEY," +
                    "species varchar(50)," +
                    "genus varchar(50))";

            stmt.execute(createSql);

            //Drop table, that this test passes more than one time
            String dropSql = "drop table test_animalSpecies";

            stmt.execute(dropSql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insertTest(){
        try {
            Statement stmt = connection.createStatement();

            String insertSql = "insert into ANIMALSPECIES (BREED, SPECIES, GENUS) values ('Feldmaus','Nagetier','Saeugetier')";

            stmt.execute(insertSql);

            //Delete insert, so that this test passes more than one time
            String deleteSql = "delete from ANIMALSPECIES where breed='Feldmaus'";

            stmt.execute(deleteSql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
