package entities;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArtistTest {

    @Test
    public void testGetId() {
        //given
        Long expected = 1L;
        Artist artist = new Artist(expected, "Edward", "Hopper", "New York", 1882);
        //when
        Long actual = artist.getId();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetId() {
        //given
        Long expected = 1L;
        Artist artist = new Artist();
        //when
        artist.setId(expected);
        Long actual = artist.getId();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetFirstName() {
        //given
        String expected = "Edward";
        Artist artist = new Artist(1L, expected, "Hopper", "New York", 1882);
        //when
        String actual = artist.getFirstName();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetFirstName() {
        //given
        String expected = "Edward";
        Artist artist = new Artist();
        //when
        artist.setFirstName(expected);
        String actual = artist.getFirstName();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetLastName() {
        //given
        String expected = "Hopper";
        Artist artist = new Artist(1L, "Edward", "Hopper", "New York", 1882);
        //when
        String actual = artist.getLastName();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetLastName() {
        //given
        String expected = "Hopper";
        Artist artist = new Artist();
        //when
        artist.setLastName(expected);
        String actual = artist.getLastName();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetBirthPlace() {
        //given
        String expected = "New York";
        Artist artist = new Artist(1L, "Edward", "Hopper", "New York", 1882);
        //when
        String actual = artist.getBirthPlace();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetBirthPlace() {
        //given
        String expected = "New York";
        Artist artist = new Artist();
        //when
        artist.setBirthPlace(expected);
        String actual = artist.getBirthPlace();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetBirthYear() {
        //given
        Integer expected = 1882;
        Artist artist = new Artist(1L, "Edward", "Hopper", "New York", 1882);
        //when
        Integer actual = artist.getBirthYear();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetBirthYear() {
        //given
        Integer expected = 1882;
        Artist artist = new Artist();
        //when
        artist.setBirthYear(expected);
        Integer actual = artist.getBirthYear();
        //then
        Assert.assertEquals(expected, actual);
    }
}