package at.htl.animalshelter.boundary;

import at.htl.animalshelter.entity.AnimalSpecies;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
}
