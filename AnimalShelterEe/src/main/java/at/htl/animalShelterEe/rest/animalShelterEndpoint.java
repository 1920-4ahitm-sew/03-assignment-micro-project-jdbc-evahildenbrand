package at.htl.animalShelterEe.rest;

import at.htl.animalShelterEe.entity.animalSpecies;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.ArrayList;
import java.util.List;

@Path("animalShelter")
public class animalShelterEndpoint {
    String DRIVER_STRING = "org.apache.derby.jdbc.ClienDriver";
    String CONNECTION_STRING = "jdbc:derby://localhost:1527/animalShelter";
    String USER = "app";
    String PASSWORD = "app";
}
