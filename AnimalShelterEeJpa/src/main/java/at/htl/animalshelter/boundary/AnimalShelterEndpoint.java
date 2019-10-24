package at.htl.animalshelter.boundary;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Path;

@Stateless
@Path("/")
public class AnimalShelterEndpoint {

    @PersistenceContext
    EntityManager em;

    @PostConstruct
    public void init(){
        System.out.println("*** AnimalShelterEndpoint created! ***");
    }
}
