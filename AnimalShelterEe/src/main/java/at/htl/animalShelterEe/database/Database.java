package at.htl.animalShelterEe.database;

import at.htl.animalShelterEe.model.AnimalSpecies;

import java.sql.*;

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

    public AnimalSpecies selectSpecies(String breed){
        openConnection();

        AnimalSpecies species = new AnimalSpecies();

        try {
            PreparedStatement preparedSelect = connection.prepareStatement("select BREED, SPECIES, GENUS from ANIMALSPECIES where BREED=?");
            preparedSelect.setString(1, breed);

            ResultSet rs = preparedSelect.executeQuery();

            if(rs.next()){
                species.setBreed(rs.getString(1));
                species.setSpecies(rs.getString(2));
                species.setGenus(rs.getString(3));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        closeConnection();

        return species;
    }
}
