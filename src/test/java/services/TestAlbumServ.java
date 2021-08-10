package services;

import entities.Album;
import entities.Artist;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestAlbumServ {


    AlbumServ albumService = new AlbumServ();


    @Test
    public void testCreate() {
        //given
        Album album = new Album(1L, "MOTS7", 14, 1853);
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
        Album a1 = new Album(1L, "Persona", 13, 4);
        Album a2 = new Album(2L, "Tear", 12, 3);
        List<Album> list = new ArrayList<>();
        list.add(a1);
        list.add(a2);
        String expected = list.toString();
        //int expected = list.size();
        //when
        albumService.createMultiple(list);
        //int actual = artistService.findAll().size();
        String actual = list.toString();
        //then
        Assert.assertEquals(expected, actual);
        albumService.delete(a1);
        albumService.delete(a2);
    }

    @Test
    public void testFindById() {
        //given
        Album album = new Album(1L, "tmbmil", 11, 3);
        String expected = album.toString();
        //when
        albumService.create(album);
        Album artist1 = albumService.findById(1L);
        String actual = artist1.toString();
        //then
        Assert.assertEquals(expected, actual);
        albumService.delete(album);
    }

    @Test
    public void testUpdate() {
        //given
        Album a1 = new Album(1L, "Namjoon", 12, 8);
        Album a2 = new Album(1L, "hyyh", 13, 4);
        String expected = a2.toString();
        //when
        albumService.create(a1);
        albumService.update(1L, a2);
        Album album = albumService.findById(1L);
        String actual = album.toString();
        //then
        Assert.assertEquals(expected, actual);
        albumService.delete(album);
    }

    @Test
    public void testDeleteByID() {
        //given
        Album a1 = new Album(1L, "Namjoon", 15, 12);
        Album a2 = new Album(2L, "Answere", 9, 17);
        List<Album> list = new ArrayList<>();
        list.add(a1);
        list.add(a2);
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
        Album a1 = new Album(1L, "Colores", 10, 23);
        Album a2 = new Album(2L, "BE", 16, 12);
        List<Album> list = new ArrayList<>();
        list.add(a1);
        list.add(a2);
        int expected = 1;
        //when
        albumService.createMultiple(list);
        albumService.delete(a2);
        int actual = albumService.findAll().size();
        //then
        Assert.assertEquals(expected, actual);
        albumService.delete(1L);
    }
}
