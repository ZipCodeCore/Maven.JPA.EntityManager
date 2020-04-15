package services;

import entities.Actor;
import entities.Movie;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class MovieServiceTest
{
    MovieService testMovieService;

    @Before
    public void setup()
    {
        testMovieService = new MovieService();
    }

    @Test
    public void addMovieTest()
    {
        Movie testMovie = new Movie();
        testMovie.setTitle("The Good, the Bad and the Ugly");
        testMovie.setDirector("Sergio Leone");
        testMovie.setReleaseDate(LocalDate.of(1967, 12, 29));

        Actor testActor = new Actor();
        testActor.setLastName("Eastwood");
        testActor.setFirstName("Clint");

        Set<Actor> testCast = new HashSet<>();
        testCast.add(testActor);

        testMovie.setCast(testCast);
        testMovie.setSummary("Three rival gungslingers search for lost Confederate gold.");

        testMovieService.create(testMovie);
        Movie actual = testMovieService.findById(1L);

        assertEquals(testMovie, actual);
    }

    @Test
    public void addMovieOtherWayTest()
    {
        testMovieService.create("Captain America: The Winter Soldier", LocalDate.of(2014, 4, 10),
                "Joe Russo", new HashSet<Actor>(), "Captain America must face off against Hydra in the modern era.");
    }

    @Test
    public void findAllMovies()
    {
        String expectedTitle = "Short Circuit";
        Movie firstMovie = new Movie();
        Movie secondMovie = new Movie();
        Movie thirdMovie = new Movie();
        List<Movie> expected = new ArrayList<>();
        firstMovie.setTitle("E.T.");
        firstMovie.setDirector("Steven Spielberg");
        firstMovie.setSummary("A boy and alien become pals.");
        firstMovie.setReleaseDate(LocalDate.of(1982, 5, 11));
        secondMovie.setTitle("Star Wars");
        thirdMovie.setTitle(expectedTitle);

        expected.add(firstMovie);
        expected.add(secondMovie);
        expected.add(thirdMovie);

        testMovieService.create(firstMovie);
        testMovieService.create(secondMovie);
        testMovieService.create(thirdMovie);

        List<Movie> actual = testMovieService.findAll();
        String actualTitle = actual.get(2).getTitle();

        assertEquals(expected, actual);
        assertEquals(expectedTitle, actualTitle);
    }

    @Test
    public void updateMovieTest()
    {
        Movie testMovie = new Movie();
        String originalTitle = "Toy Story II";
        testMovie.setTitle(originalTitle);
        testMovieService.create(testMovie);
        String actualOriginalTitle = testMovieService.findById(1L).getTitle();
        assertEquals(originalTitle, actualOriginalTitle);

        String changedTitle = "Toy Story 2";
        testMovie.setTitle(changedTitle);
        testMovieService.update(1L, testMovie);
        String actualChangedTitle = testMovieService.findById(1L).getTitle();

        assertEquals(changedTitle, actualChangedTitle);
    }

    @Test
    public void deleteAMovie()
    {
        Movie testMovie = new Movie();
        testMovie.setTitle("Fight Club");

        testMovieService.create(testMovie);
        List<Movie> persistentMovies = testMovieService.findAll();
        assertEquals(true, persistentMovies.contains(testMovie));

        testMovieService.delete(testMovie);
        persistentMovies = testMovieService.findAll();
        assertEquals(false, persistentMovies.contains(testMovie));
    }
}
