package at.htl.animalShelterEe.rest;

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

    @GET
    @Path("{id}")
    public AnimalSpecies find(@PathParam("id") long id){
        return new AnimalSpecies("Wildkatze" + id, "Katze", "Saeugetier");
    }

    @GET
    public List<AnimalSpecies> findAll(){
        List<AnimalSpecies> all = new ArrayList<>();
        all.add(find(42));
        return all;
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") long id){
        System.out.println("deleted" + id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void save(AnimalSpecies vehicle){
        System.out.println("Vehicle = " + vehicle);
    }
}
