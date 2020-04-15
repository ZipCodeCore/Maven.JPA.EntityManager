package services;

import entities.Actor;
import entities.Movie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ActorService
{
    EntityManagerFactory emf;
    EntityManager em;
    List<Actor> actorList;

    public ActorService()
    {
        emf = Persistence.createEntityManagerFactory("movieDB");
        em = emf.createEntityManager();
        actorList = new ArrayList<>();
    }

    public List<Actor> findAll()
    {
        return em.createQuery("SELECT a FROM Actor a", Actor.class).getResultList();
    }

    public Actor findById(Long id)
    {
        return em.find(Actor.class, id);
    }

    public Actor create(Actor actor)
    {
        em.getTransaction().begin();
        em.persist(actor);
        em.getTransaction().commit();

        return actor;
    }

    public Actor create(Long id, String firstName, String lastName, String gender, LocalDate birthDate,
                        String nationality, Set<Movie> filmography)
    {
        Actor createdActor = new Actor();
        createdActor.setId(id);
        createdActor.setFirstName(firstName);
        createdActor.setLastName(lastName);
        createdActor.setGender(gender);
        createdActor.setBirthDate(birthDate);
        createdActor.setNationality(nationality);
        createdActor.setFilmography(filmography);
        em.getTransaction().begin();
        em.persist(createdActor);
        em.getTransaction().commit();

        return createdActor;
    }

    public void update(Long id, Actor actor)
    {
        em.getTransaction().begin();
        Actor persistentActor = em.find(Actor.class, id);
        persistentActor.setFirstName(actor.getFirstName());
        persistentActor.setLastName(actor.getLastName());
        persistentActor.setGender(actor.getGender());
        persistentActor.setBirthDate(actor.getBirthDate());
        persistentActor.setNationality(actor.getNationality());
        persistentActor.setFilmography(actor.getFilmography());
        em.getTransaction().commit();
    }

    public void delete(Long id)
    {
        Actor actorToRemove = em.find(Actor.class, id);
        if(actorToRemove != null)
        {
            em.getTransaction().begin();
            em.remove(actorToRemove);
            em.getTransaction().commit();
        }
    }

    public void delete(Actor actor)
    {
        em.getTransaction().begin();
        em.remove(actor);
        em.getTransaction().commit();
    }
}
