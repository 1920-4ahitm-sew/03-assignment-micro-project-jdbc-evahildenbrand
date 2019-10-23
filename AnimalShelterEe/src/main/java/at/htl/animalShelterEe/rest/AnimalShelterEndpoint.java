package at.htl.animalShelterEe.rest;

import at.htl.animalShelterEe.database.Database;
import at.htl.animalShelterEe.model.AnimalSpecies;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("animalShelter")
@Produces({
        MediaType.APPLICATION_JSON,
        MediaType.TEXT_PLAIN,
        MediaType.APPLICATION_XML
})
public class AnimalShelterEndpoint {

    static Database db = new Database();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{breed}")
    public AnimalSpecies findAnimalSpecies(@PathParam("breed") String breed){
        return db.selectSpecies(breed);
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<AnimalSpecies> findAllAnimalSpecies(){
        return db.selectAllAnimalSpecies();
    }

    @DELETE
    @Path("{breed}")
    public void deleteAnimalSpecies(@PathParam("breed") String breed){
        db.deleteAnimalSpecies(breed);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertAnimalSpecies(AnimalSpecies species){
        if(species != null){
            db.insertAnimalSpecies(species);
        }
    }

    @PUT
    @Path("{breed}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateAnimalSpecies(@PathParam("breed") String breed, AnimalSpecies updatedSpecies){
        if(updatedSpecies != null){
            AnimalSpecies species = db.selectSpecies(breed);

            species.setSpecies(updatedSpecies.getSpecies());
            species.setGenus(updatedSpecies.getGenus());

            db.updateAnimalSpecies(species);
        }
    }
}
