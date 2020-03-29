package services;

import entities.Movie;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

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
        testMovie.setSummary("Three rival gungslingers search for lost Confederate gold.");

        testMovieService.create(testMovie);
        Movie actual = testMovieService.findById(1L);

        assertEquals(testMovie, actual);
    }
}