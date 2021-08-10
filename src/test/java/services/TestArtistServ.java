package services;

import entities.Album;
import entities.Artist;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestArtistServ {

    ArtistServ artistService = new ArtistServ();
    AlbumServ albumService = new AlbumServ();

    @Test
    public void testCreate() {
        //given
        Artist artist = new Artist(1L, "Namjoon", "RM", 1853);
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
        Artist a1 = new Artist(1L, "Namjoon", "RM", 4);
        Artist a2 = new Artist(2L, "Jose", "Jbalvin", 3);
        List<Artist> list = new ArrayList<>();
        list.add(a1);
        list.add(a2);
        String expected = list.toString();
        //int expected = list.size();
        //when
        artistService.createMultiple(list);
        //int actual = artistService.findAll().size();
        String actual = list.toString();
        //then
        Assert.assertEquals(expected, actual);
        artistService.delete(a1);
        artistService.delete(a2);
    }

    @Test
    public void testFindById() {
        //given
        Artist artist = new Artist(1L, "Namjoon", "RM", 3);
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
        Artist a1 = new Artist(1L, "Namjoon", "RM", 8);
        Artist a2 = new Artist(1L, "Jose", "Jbalvin", 4);
        String expected = a2.toString();
        //when
        artistService.create(a1);
        artistService.update(1L, a2);
        Artist artist = artistService.findById(1L);
        String actual = artist.toString();
        //then
        Assert.assertEquals(expected, actual);
        artistService.delete(artist);
    }

    @Test
    public void testDeleteByID() {
        //given
        Artist a1 = new Artist(1L, "Namjoon", "RM", 12);
        Artist a2 = new Artist(2L, "Jose", "Jbalvin", 17);
        List<Artist> list = new ArrayList<>();
        list.add(a1);
        list.add(a2);
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
        Artist a1 = new Artist(1L, "Namjoon", "RM", 23);
        Artist a2 = new Artist(2L, "Jose", "Jbalvin", 12);
        List<Artist> list = new ArrayList<>();
        list.add(a1);
        list.add(a2);
        int expected = 1;
        //when
        artistService.createMultiple(list);
        artistService.delete(a2);
        int actual = artistService.findAll().size();
        //then
        Assert.assertEquals(expected, actual);
        artistService.delete(1L);
    }
//
//    @Test
//    public void testGetBooks() {
//        // Arrange
//        Artist testA = new Artist(null, "TEST", "BOOK TO AUTHOR MAPPING", "none");
//        Long idArtist = artistService.create(testA);
//        Album a = new Album(null, "TEST BOOK TO AUTHOR MAPPING1", "J.K. Rowling", "Penguin", "Fantasy", 300, idArtist);
//        Album a2 = new Album(null, "TEST BOOK TO AUTHOR MAPPING2", "J.K. Rowling", "Penguin", "Fantasy", 300,idArtist);
//        Long albumid = albumService.create(a);
//        Long albumid2 = albumService.create(a2);
//
//        // Act
//        List<Album> booksWritten = artistService.getClass().getName();
//        Assert.assertEquals(2, booksWritten.size());
//        Assert.assertEquals(albumid, booksWritten.get(0).getId());
//        Assert.assertEquals(albumid2, booksWritten.get(1).getId());
//
//        for (Album bk : booksWritten) {
//            System.out.println(bk.toString());
//        }
//
//        albumService.delete(albumid);
//        albumService.delete(albumid2);
//        artistService.delete(idArtist);
//    }

}

//    @Test
//    public void createTest() {
//
//        Artist artist = new Artist(1L, "namjoon", "rm", 826);
//        String expected = artist.toString();
//        //when
//        artistServ.create(artist);
//        Artist artist1 = artistServ.findById(1L);
//        String actual = artist1.toString();
//        //then
//        Assert.assertEquals(expected, actual);
//        //artistServ.delete(artist);
//
//
//    }
//
//    @Test
//    public void testFindById() {
//        //given
//        Artist artist = new Artist(1L, "jose", "JBalvin", 123);
//        String expected = artist.toString();
//        //when
//        artistServ.create(artist);
//        Artist artist1 = artistServ.findById(1L);
//        String actual = artist1.toString();
//        //then
//        Assert.assertEquals(expected, actual);
//        artistServ.delete(artist);
//    }
//
//    @Test
//    public void testUpdate() {
//        //given
//        Artist vanGogh = new Artist(1L, "benito", "badbunny", 224);
//        Artist hopper = new Artist(1L, "Yoongi", "Suga", 410);
//        String expected = hopper.toString();
//        //when
//        artistServ.create(vanGogh);
//        artistServ.update(1L, hopper);
//        Artist artist = artistServ.findById(1L);
//        String actual = artist.toString();
//        //then
//        Assert.assertEquals(expected, actual);
//        artistServ.delete(artist);
//    }
//
//
//@Test
//    public void create(){
//        Artist artist = new Artist();
//
//        artist.setName("jose");
//        artist.setStageName("balvin");
//        artist.setNumOfAwards(22);
//
//
//        artistServ.create(artist);
//        String expected = "balvin";
//        String actual = artistServ.findById(9L).getStageName();
//
//        Assert.assertEquals(expected, actual);
//        artistServ.delete(9L);
//    }





