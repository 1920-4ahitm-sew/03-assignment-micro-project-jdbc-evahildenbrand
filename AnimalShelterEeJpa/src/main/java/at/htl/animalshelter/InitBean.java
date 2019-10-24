package at.htl.animalshelter;

import at.htl.animalshelter.entity.AnimalSpecies;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Destroyed;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
public class InitBean {

    @PersistenceContext
    EntityManager em;

    public void init(@Observes @Initialized(ApplicationScoped.class) Object init){
        System.out.println("*** It works! ***");

        em.persist(new AnimalSpecies("Wildkatze","Katze","Saeugetier"));
        em.persist(new AnimalSpecies("Siamkatze","Katze","Saeugetier"));
        em.persist(new AnimalSpecies("Golden Retriever","Hund","Saeugetier"));
        em.persist(new AnimalSpecies("Border Collie","Hund","Saeugetier"));
    }

    public void tearDown(@Observes @Destroyed(ApplicationScoped.class) Object init){
        
    }
}
