package at.htl.animalshelterse.rest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

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

    //Start Database of AnimalShelterSe-st for this test
//    @Test
//    public void createTest(){
//        try {
//            Statement stmt = connection.createStatement();
//
//            String createSql = "CREATE TABLE test_animalSpecies(" +
//                    "breed varchar(50) constraint breedPk PRIMARY KEY," +
//                    "species varchar(50)," +
//                    "genus varchar(50))";
//
//            stmt.execute(createSql);
//
//            //Drop table, that this test passes more than one time
//            String dropSql = "drop table test_animalSpecies";
//
//            stmt.execute(dropSql);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    @Test
    public void insertTest(){
        try {
            Statement stmt = connection.createStatement();

            String insertSql = "insert into ANIMALSPECIES (BREED, SPECIES, GENUS) values ('Testtier','Testspecies','Testgattung')";

            stmt.execute(insertSql);

            //Delete insert, so that this test passes more than one time
//            String deleteSql = "delete from ANIMALSPECIES where breed='Testtier'";
//
//            stmt.execute(deleteSql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectTest(){
        try {
            Statement stmt = connection.createStatement();

            String selectSql =  "select breed,species,genus from ANIMALSPECIES where breed='Testtier'";

            ResultSet rs = stmt.executeQuery(selectSql);

//            rs.next();
//            assertThat(rs.getString("breed"),is("Wildkatze"));
//            assertThat(rs.getString("species"),is("Katze"));
//            assertThat(rs.getString("genus"),is("Saeugetier"));
//            rs.next();
//            assertThat(rs.getString("breed"),is("Siamkatze"));
//            assertThat(rs.getString("species"),is("Katze"));
//            assertThat(rs.getString("genus"),is("Saeugetier"));
//            rs.next();
//            assertThat(rs.getString("breed"),is("Golden Retriever"));
//            assertThat(rs.getString("species"),is("Hund"));
//            assertThat(rs.getString("genus"),is("Saeugetier"));
//            rs.next();
//            assertThat(rs.getString("breed"),is("Border Collie"));
//            assertThat(rs.getString("species"),is("Hund"));
//            assertThat(rs.getString("genus"),is("Saeugetier"));

            rs.next();
            assertThat(rs.getString("breed"),is("Testtier"));
            assertThat(rs.getString("species"),is("Testspecies"));
            assertThat(rs.getString("genus"),is("Testgattung"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateTest(){
        try {
            Statement stmt = connection.createStatement();

            String updateSql = "update ANIMALSPECIES set SPECIES='UpdateSpecies' where BREED='Testtier'";

            stmt.executeUpdate(updateSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
