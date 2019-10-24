package at.htl.animalshelter.boundary;

import at.htl.animalshelter.entity.AnimalSpecies;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.util.List;

@Stateless
@Path("/")
public class AnimalShelterEndpoint {

    @PersistenceContext
    EntityManager em;

    @PostConstruct
    public void init(){
        System.out.println("*** AnimalShelterEndpoint created! ***");
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{breed}")
    public AnimalSpecies findAnimalSpecies(@PathParam("breed") String breed){
        return em.find(AnimalSpecies.class, breed);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<AnimalSpecies> findAllAnimalSpecies(){
        return em.createNamedQuery("AnimalSpecies.findall",AnimalSpecies.class).getResultList();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertAnimalSpecies(AnimalSpecies species){
        em.persist(species);
        System.out.println(species + " was inserted in DB!");
    }

    @PUT
    @Path("{breed}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateAnimalSpecies(@PathParam("breed") String breed, AnimalSpecies updatedSpecies){
        AnimalSpecies species = em.find(AnimalSpecies.class,breed);

        species.setSpecies(updatedSpecies.getSpecies());
        species.setGenus(updatedSpecies.getGenus());

        em.merge(species);
        System.out.println(species + " was updated in DB!");
    }

    @DELETE
    @Path("{breed}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteAnimalSpecies(@PathParam("breed") String breed){
        em.remove(em.find(AnimalSpecies.class,breed));
        System.out.println(breed + " was deleted from DB!");
    }
}
