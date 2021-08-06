package services;

import entities.Artist;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ArtistRepositoryTest {


    @Test
    public void testCreate() {
        //given
        Artist artist = new Artist(1L, "Vincent van Gogh", "Netherlands", 1853);
        String expected = artist.toString();
        //when
        Connection connection = main.SQLConnect.getConnection("mysql");
        ArtistRepository artistRepository = new ArtistRepository(connection);
        artistRepository.create(artist);
        Artist artist1 = artistRepository.findById(1L);
        String actual = artist1.toString();
        //then
        Assert.assertEquals(expected, actual);
        artistRepository.delete(1L);
    }

    @Test
    public void testFindAll() {
        //given
        Artist artist1 = new Artist(1L, "Vincent van Gogh", "Netherlands", 1853);
        Artist artist2 = new Artist(2L, "Edward Hopper", "New York", 1882);
        List<Artist> list = new ArrayList<>();
        list.add(artist1);
        list.add(artist2);
        String expected = list.toString();
        //when
        Connection connection = main.SQLConnect.getConnection("mysql");
        ArtistRepository artistRepository = new ArtistRepository(connection);
        artistRepository.create(artist1);
        artistRepository.create(artist2);
        String actual = artistRepository.findAll().toString();
        //then
        Assert.assertEquals(expected, actual);
        artistRepository.delete(1L);
        artistRepository.delete(2L);
    }

    @Test
    public void testFindById() {
        //given
        Artist artist = new Artist(1L, "Vincent van Gogh", "Netherlands", 1853);
        String expected = artist.toString();
        //when
        Connection connection = main.SQLConnect.getConnection("mysql");
        ArtistRepository artistRepository = new ArtistRepository(connection);
        artistRepository.create(artist);
        Artist artist1 = artistRepository.findById(1L);
        String actual = artist1.toString();
        //then
        Assert.assertEquals(expected, actual);
        artistRepository.delete(1L);
    }

    @Test
    public void testUpdate() {
        //given
        Artist artist = new Artist(1L, "Vincent van Gogh", "Netherlands", 1853);
        Artist newArtist = new Artist(1L, "Edward Hopper", "New York", 1882);
        String expected = newArtist.toString();
        //when
        Connection connection = main.SQLConnect.getConnection("mysql");
        ArtistRepository artistRepository = new ArtistRepository(connection);
        artistRepository.create(artist);
        artistRepository.update(1L, newArtist);
        Artist artist1 = artistRepository.findById(1L);
        String actual = artist1.toString();
        //then
        Assert.assertEquals(expected, actual);
        artistRepository.delete(1L);
    }

    @Test
    public void testDeleteByID() {
        //given
        Artist artist1 = new Artist(1L, "Vincent van Gogh", "Netherlands", 1853);
        Artist artist2 = new Artist(2L, "Edward Hopper", "New York", 1882);
        int expected = 1;
        //when
        Connection connection = main.SQLConnect.getConnection("mysql");
        ArtistRepository artistRepository = new ArtistRepository(connection);
        artistRepository.create(artist1);
        artistRepository.create(artist2);
        artistRepository.delete(2L);
        int actual = artistRepository.findAll().size();
        //then
        Assert.assertEquals(expected, actual);
        artistRepository.delete(1L);
    }

    @Test
    public void testDeleteByObject() {
        //given
        Artist artist1 = new Artist(1L, "Vincent van Gogh", "Netherlands", 1853);
        Artist artist2 = new Artist(2L, "Edward Hopper", "New York", 1882);
        int expected = 1;
        //when
        Connection connection = main.SQLConnect.getConnection("mysql");
        ArtistRepository artistRepository = new ArtistRepository(connection);
        artistRepository.create(artist1);
        artistRepository.create(artist2);
        artistRepository.delete(artist2);
        int actual = artistRepository.findAll().size();
        //then
        Assert.assertEquals(expected, actual);
        artistRepository.delete(1L);
    }
}