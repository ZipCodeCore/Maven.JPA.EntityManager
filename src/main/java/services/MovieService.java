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
        return em.createQuery("SELECT m FROM Movie m", Movie.class).getResultList();
    }

    public Movie findById(Long id)
    {
        return em.find(Movie.class, id);
    }

    public Movie create(Movie movie)
    {
        em.getTransaction().begin();
        em.persist(movie);
        em.getTransaction().commit();

        return movie;
    }

    public Movie create(Long id, String title, LocalDate releaseDate, String director, Set<Actor> cast, String summary)
    {
        Movie createdMovie = new Movie();
        createdMovie.setId(id);
        createdMovie.setTitle(title);
        createdMovie.setReleaseDate(releaseDate);
        createdMovie.setDirector(director);
        createdMovie.setCast(cast);
        createdMovie.setSummary(summary);
        em.getTransaction().begin();
        em.persist(createdMovie);
        em.getTransaction().commit();

        return createdMovie;
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
        Movie movieToRemove = em.find(Movie.class, id);
        if(movieToRemove != null)
        {
            em.getTransaction().begin();
            em.remove(movieToRemove);
            em.getTransaction().commit();
        }
    }

    public void delete(Movie movie)
    {
        em.getTransaction().begin();
        em.remove(movie);
        em.getTransaction().commit();
    }
}