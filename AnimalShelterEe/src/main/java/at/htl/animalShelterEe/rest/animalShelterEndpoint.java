package at.htl.animalShelterEe.rest;

import at.htl.animalShelterEe.model.animalSpecies;

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
public class animalShelterEndpoint {

    @GET
    @Path("{id}")
    public animalSpecies find(@PathParam("id") long id){
        return new animalSpecies("Wildkatze" + id, "Katze", "Saeugetier");
    }

    @GET
    public List<animalSpecies> findAll(){
        List<animalSpecies> all = new ArrayList<>();
        all.add(find(42));
        return all;
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") long id){
        System.out.println("deleted" + id);
    }

}
