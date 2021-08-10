package services;

import entities.Artist;
import entities.Album;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class AlbumServiceTest {

    AlbumService albumService = new AlbumService();
    Artist vanGogh = new Artist(1L, "Vincent van Gogh", "Netherlands", 1853);
    Artist hopper = new Artist(2L, "Edward Hopper", "New York", 1882);


    @Test
    public void testCreate() {
        //given
        Album album = new Album(1L, "Almond Blossom", "oil", "Vincent van Gogh", vanGogh);
        String expected = album.toString();
        //when
        albumService.create(album);
        Album album1 = albumService.findById(1L);
        String actual = album1.toString();
        //then
        Assert.assertEquals(expected, actual);
        albumService.delete(album);
    }

    @Test
    public void testFindAll() {
        //given
        Album almondBlossom = new Album(1L, "Almond Blossom", "oil", "Vincent van Gogh", vanGogh);
        Album nightHawks = new Album(2L, "NightHawks", "oil", "Edward Hopper", hopper);
        List<Album> list = new ArrayList<>();
        list.add(almondBlossom);
        list.add(nightHawks);
        String expected = list.toString();
        //when
        albumService.createMultiple(list);
        String actual = albumService.findAll().toString();
        //then
        Assert.assertEquals(expected, actual);
        albumService.delete(almondBlossom);
        albumService.delete(nightHawks);
    }

    @Test
    public void testFindById() {
        //given
        Album album = new Album(1L, "Almond Blossom", "oil", "Vincent van Gogh", vanGogh);
        List<Album> list = new ArrayList<>();
        list.add(album);
        String expected = album.toString();
        //when
        albumService.create(album);
        Album album1 = albumService.findById(1L);
        String actual = album1.toString();
        //then
        Assert.assertEquals(expected, actual);
        albumService.delete(album);
    }

    @Test
    public void testUpdate() {
        //given
        Album almondBlossom = new Album(1L, "Almond Blossom", "oil", "Vincent van Gogh", vanGogh);
        Album nightHawks = new Album(1L, "NightHawks", "oil", "Edward Hopper", hopper);
        String expected = nightHawks.toString();
        //when
        albumService.create(almondBlossom);
        albumService.update(1L, nightHawks);
        Album album = albumService.findById(1L);
        String actual = album.toString();
        //then
        Assert.assertEquals(expected, actual);
        albumService.delete(album);
    }

    @Test
    public void testDeleteByID() {
        //given
        Album almondBlossom = new Album(1L, "Almond Blossom", "oil", "Vincent van Gogh", vanGogh);
        Album nightHawks = new Album(2L, "NightHawks", "oil", "Edward Hopper", hopper);
        List<Album> list = new ArrayList<>();
        list.add(almondBlossom);
        list.add(nightHawks);
        int expected = 1;
        //when
        albumService.createMultiple(list);
        albumService.delete(2L);
        int actual = albumService.findAll().size();
        //then
        Assert.assertEquals(expected, actual);
        albumService.delete(1L);
    }

    @Test
    public void testDeleteByObject() {
        //given
        Album almondBlossom = new Album(1L, "Almond Blossom", "oil", "Vincent van Gogh", vanGogh);
        Album nightHawks = new Album(2L, "NightHawks", "oil", "Edward Hopper", hopper);
        List<Album> list = new ArrayList<>();
        list.add(almondBlossom);
        list.add(nightHawks);
        int expected = 1;
        //when
        albumService.createMultiple(list);
        albumService.delete(nightHawks);
        int actual = albumService.findAll().size();
        //then
        Assert.assertEquals(expected, actual);
        albumService.delete(1L);
    }
}
