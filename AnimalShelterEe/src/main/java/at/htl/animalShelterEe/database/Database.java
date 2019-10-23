package at.htl.animalShelterEe.database;

import at.htl.animalShelterEe.model.AnimalSpecies;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

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

    public List<AnimalSpecies> selectAllAnimalSpecies(){
        List<AnimalSpecies> speciesList = new LinkedList<>();

        openConnection();

        try {
            PreparedStatement selectAll = connection.prepareStatement("select BREED, SPECIES, GENUS from ANIMALSPECIES");

            ResultSet rs = selectAll.executeQuery();
            AnimalSpecies species;

            while (rs.next()){
                species = new AnimalSpecies();

                species.setBreed(rs.getString(1));
                species.setSpecies(rs.getString(2));
                species.setGenus(rs.getString(3));

                speciesList.add(species);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        closeConnection();

        return speciesList;
    }

    public void insertAnimalSpecies(AnimalSpecies species){
        openConnection();

        try {
            PreparedStatement insertSpecies = connection.prepareStatement("insert into ANIMALSPECIES (BREED, SPECIES, GENUS) values (?,?,?)");

            insertSpecies.setString(1, species.getBreed());
            insertSpecies.setString(2, species.getSpecies());
            insertSpecies.setString(3, species.getGenus());

            insertSpecies.execute();

            System.out.println(species + " inserted in table AnimalSpecies!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        closeConnection();
    }

    public void deleteAnimalSpecies(String breed){
        openConnection();

        try {
            PreparedStatement deleteSpecies = connection.prepareStatement("delete from ANIMALSPECIES where BREED=?");

            deleteSpecies.setString(1,breed);

            deleteSpecies.execute();

            System.out.println("The AnimalSpecies " + breed + " was deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        closeConnection();
    }
}
