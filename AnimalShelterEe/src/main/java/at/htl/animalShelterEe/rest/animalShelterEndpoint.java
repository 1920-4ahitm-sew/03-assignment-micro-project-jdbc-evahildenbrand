package at.htl.animalShelterEe.rest;

import at.htl.animalShelterEe.entity.animalSpecies;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Path("animalShelter")
public class animalShelterEndpoint {
    static final String DRIVER_STRING = "org.apache.derby.jdbc.ClienDriver";
    static final String CONNECTION_STRING = "jdbc:derby://localhost:1527/animalShelter";
    static final String USER = "app";
    static final String PASSWORD = "app";

    static animalShelterEndpoint instance = null; // singelton
    private Connection connection;

    public static synchronized animalShelterEndpoint getInstance() {
        if (instance == null) {
            instance = new animalShelterEndpoint();
        }
        return instance;
    }

    private animalShelterEndpoint() {
        connection = null;
        try {
            Class.forName(DRIVER_STRING);
            connection = DriverManager.getConnection(CONNECTION_STRING, USER, PASSWORD);
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(true);

        } catch (ClassNotFoundException e) {
            System.err.println("Treiber laden nicht moeglich. Wurde Java DB Driver lib hinzugefuegt? " + e + "\n");
            System.exit(1);
        } catch (SQLException e) {
            System.err.println("Verbindung zur Datenbank nicht moeglich. Wurde Datenbank gestartet? " + e + "\n");
            System.exit(2);
        }
    }

}
