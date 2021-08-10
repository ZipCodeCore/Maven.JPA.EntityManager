package services;

import entities.Artist;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ArtistServiceTest {

    ArtistService artistService = new ArtistService();


    @Test
    public void testCreate() {
        //given
        Artist artist = new Artist(1L, "Vincent van Gogh", "Netherlands", 1853);
        String expected = artist.toString();
        //when
        artistService.create(artist);
        Artist artist1 = artistService.findById(1L);
        String actual = artist1.toString();
        //then
        Assert.assertEquals(expected, actual);
        artistService.delete(artist);
    }

    @Test
    public void testFindAll() {
        //given
        Artist vanGogh = new Artist(1L, "Vincent van Gogh", "Netherlands", 1853);
        Artist hopper = new Artist(2L, "Edward Hopper", "New York", 1882);
        List<Artist> list = new ArrayList<>();
        list.add(vanGogh);
        list.add(hopper);
        String expected = list.toString();
        //when
        artistService.createMultiple(list);
        String actual = artistService.findAll().toString();
        //then
        Assert.assertEquals(expected, actual);
        artistService.delete(vanGogh);
        artistService.delete(hopper);
    }

    @Test
    public void testFindById() {
        //given
        Artist artist = new Artist(1L, "Vincent van Gogh", "Netherlands", 1853);
        String expected = artist.toString();
        //when
        artistService.create(artist);
        Artist artist1 = artistService.findById(1L);
        String actual = artist1.toString();
        //then
        Assert.assertEquals(expected, actual);
        artistService.delete(artist);
    }

    @Test
    public void testUpdate() {
        //given
        Artist vanGogh = new Artist(1L, "Vincent van Gogh", "Netherlands", 1853);
        Artist hopper = new Artist(1L, "Edward Hopper", "New York", 1882);
        String expected = hopper.toString();
        //when
        artistService.create(vanGogh);
        artistService.update(1L, hopper);
        Artist artist = artistService.findById(1L);
        String actual = artist.toString();
        //then
        Assert.assertEquals(expected, actual);
        artistService.delete(artist);
    }

    @Test
    public void testDeleteByID() {
        //given
        Artist vanGogh = new Artist(1L, "Vincent van Gogh", "Netherlands", 1853);
        Artist hopper = new Artist(2L, "Edward Hopper", "New York", 1882);
        List<Artist> list = new ArrayList<>();
        list.add(vanGogh);
        list.add(hopper);
        int expected = 1;
        //when
        artistService.createMultiple(list);
        artistService.delete(2L);
        int actual = artistService.findAll().size();
        //then
        Assert.assertEquals(expected, actual);
        artistService.delete(1L);
    }

    @Test
    public void testDeleteByObject() {
        //given
        Artist vanGogh = new Artist(1L, "Vincent van Gogh", "Netherlands", 1853);
        Artist hopper = new Artist(2L, "Edward Hopper", "New York", 1882);
        List<Artist> list = new ArrayList<>();
        list.add(vanGogh);
        list.add(hopper);
        int expected = 1;
        //when
        artistService.createMultiple(list);
        artistService.delete(hopper);
        int actual = artistService.findAll().size();
        //then
        Assert.assertEquals(expected, actual);
        artistService.delete(1L);
    }
}