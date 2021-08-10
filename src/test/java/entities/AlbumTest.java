package entities;

import org.junit.Assert;
import org.junit.Test;

public class AlbumTest {

    Artist artist = new Artist(1L, "Edward Hopper", "New York", 1882);

    @Test
    public void testGetId() {
        //given
        Long expected = 1L;
        Album album = new Album(1L, "Nighthawks", "oil", "Edward Hopper", artist);
        //when
        Long actual = album.getId();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetId() {
        //given
        Long expected = 1L;
        Album album = new Album();
        //when
        album.setId(expected);
        Long actual = album.getId();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetTitle() {
        //given
        String expected = "Nighthawks";
        Album album = new Album(1L, "Nighthawks", "oil", "Edward Hopper", artist);
        //when
        String actual = album.getTitle();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetTitle() {
        //given
        String expected = "Nighthawks";
        Album album = new Album();
        //when
        album.setTitle(expected);
        String actual = album.getTitle();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetMedium() {
        //given
        String expected = "oil";
        Album album = new Album(1L, "Nighthawks", "oil", "Edward Hopper", artist);
        //when
        String actual = album.getGenre();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetMedium() {
        //given
        String expected = "oil";
        Album album = new Album();
        //when
        album.setGenre(expected);
        String actual = album.getGenre();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetArtistName() {
        //given
        String expected = "Edward Hopper";
        Album album = new Album(1L, "Nighthawks", "oil", "Edward Hopper", artist);
        //when
        String actual = album.getArtistName();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetArtistName() {
        //given
        String expected = "Edward Hopper";
        Album album = new Album();
        //when
        album.setArtistName(expected);
        String actual = album.getArtistName();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetArtist() {
        //given
        Artist expected = artist;
        Album album = new Album(1L, "Nighthawks", "oil", "Edward Hopper", artist);
        //when
        Artist actual = album.getArtist();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetArtist() {
        //given
        Artist expected = new Artist(1L, "Edward Hopper", "New York", 1882);
        Album album = new Album();
        //when
        album.setArtist(expected);
        Artist actual = album.getArtist();
        //then
        Assert.assertEquals(expected, actual);
    }
}