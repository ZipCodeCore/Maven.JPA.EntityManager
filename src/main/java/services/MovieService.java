package services;

import entities.Movie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class MovieService
{
    EntityManagerFactory emf;
    EntityManager em;
    List<Movie> movieList;

    public MovieService()
    {
        emf = Persistence.createEntityManagerFactory("movieDB");
        em = emf.createEntityManager();
        movieList = new ArrayList<>();
    }

    public List<Movie> findAll()
    {
        return em.createQuery("SELECT m FROM movie m", Movie.class).getResultList();
    }

    public Movie findById(Long id)
    {
        return em.find(Movie.class, id);
    }

    public void create(Movie movie)
    {
        em.getTransaction().begin();
        em.persist(movie);
        em.getTransaction().commit();
    }

    public void update(Long id, Movie movie)
    {
        em.getTransaction().begin();
        Movie persistentMovie = em.find(Movie.class, id);
        persistentMovie.setTitle(movie.getTitle());
        persistentMovie.setReleaseDate(movie.getReleaseDate());
        persistentMovie.setDirector(movie.getDirector());
        persistentMovie.setCast(movie.getCast());
        persistentMovie.setSummary(movie.getSummary());
        em.getTransaction().commit();
    }

    public void delete(Long id)
    {
        em.getTransaction().begin();
        Movie movieToRemove = em.find(Movie.class, id);
        if(movieToRemove != null)
        {
            em.remove(movieToRemove);
        }
        em.getTransaction().commit();
    }
}