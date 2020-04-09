package services;

import entities.Actor;
import entities.Movie;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ActorServiceTest
{
    ActorService testActorService;
    MovieService testMovieService;

    @Before
    public void init()
    {
        testActorService = new ActorService();
        testMovieService = new MovieService();
    }

    @Test
    public void createActorTest()
    {
        Actor testActor = new Actor();
        testActor.setFirstName("Chris");
        testActor.setLastName("Pine");
        testActor.setNationality("American");
        testActor.setBirthDate(LocalDate.of(1980, 8, 26));
        testActor.setGender("male");

        Movie testMovieA = new Movie();
        Movie testMovieB = new Movie();
        testMovieA.setTitle("Star Trek");
        testMovieB.setTitle("Wonder Woman");
        Set<Movie> films = new HashSet<>();
        films.add(testMovieA);
        films.add(testMovieB);

        testActor.setFilmography(films);

        testActorService.create(testActor);
    }

    @Test
    public void createActorsSameMovie()
    {
        Actor testTomHanks = new Actor();
        testTomHanks.setFirstName("Tom");
        testTomHanks.setLastName("Hanks");
        testTomHanks.setBirthDate(LocalDate.of(1967, 3, 21));
        Actor testMegRyan = new Actor();
        testMegRyan.setFirstName("Meg");
        testMegRyan.setLastName("Ryan");
        testMegRyan.setBirthDate(LocalDate.of(1969, 11, 2));
        Movie testJoe = new Movie();
        testJoe.setTitle("Joe Vs. the Volcano");
        testJoe.setReleaseDate(LocalDate.of(1988, 7, 11));
        Movie testSleepless = new Movie();
        testSleepless.setTitle("Sleepless In Seattle");
        testSleepless.setReleaseDate(LocalDate.of(1992, 11, 20));
        Movie testMail = new Movie();
        testMail.setTitle("You've Got Mail");
        testMail.setReleaseDate(LocalDate.of(1995, 5, 31));
        Movie testDupeMail = new Movie();
        testDupeMail.setTitle("You've Got Mail");
        testDupeMail.setReleaseDate(LocalDate.of(1995, 5, 31));

        Set<Movie> hanksFilms = new HashSet<>();
        hanksFilms.add(testJoe);
        hanksFilms.add(testSleepless);
        hanksFilms.add(testMail);

        Set<Movie> ryanFilms = new HashSet<>();
        ryanFilms.add(testJoe);
        ryanFilms.add(testSleepless);
        ryanFilms.add(testDupeMail);

        testTomHanks.setFilmography(hanksFilms);
        testMegRyan.setFilmography(ryanFilms);

        testActorService.create(testTomHanks);
        testActorService.create(testMegRyan);

        List<Movie> movies = testMovieService.findAll();

        for(Movie movie : movies)
        {
            System.out.println(movie.getTitle());
            System.out.println("=======");
            Set<Actor> cast = movie.getCast();
            for(Actor actor : cast)
            {
                System.out.println("Actor: " + actor.getFirstName() + " " + actor.getLastName());
            }
            System.out.println("\n");
        }
    }
}
