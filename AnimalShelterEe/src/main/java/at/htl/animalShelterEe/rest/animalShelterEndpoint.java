package at.htl.animalShelterEe.rest;

import at.htl.animalShelterEe.model.animalSpecies;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("animalShelter")
@Produces({
        MediaType.APPLICATION_JSON,
        MediaType.TEXT_PLAIN,
        MediaType.APPLICATION_XML
})
public class animalShelterEndpoint {
    

}
