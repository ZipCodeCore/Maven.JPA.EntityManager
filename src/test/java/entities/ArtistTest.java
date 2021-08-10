package entities;

import org.junit.Assert;
import org.junit.Test;


public class ArtistTest {

    @Test
    public void testGetId() {
        //given
        Long expected = 1L;
        Artist artist = new Artist(expected, "Edward Hopper", "New York", 1882);
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
    public void testGetName() {
        //given
        String expected = "Edward Hopper";
        Artist artist = new Artist(1L, "Edward Hopper", "New York", 1882);
        //when
        String actual = artist.getName();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetName() {
        //given
        String expected = "Edward Hopper";
        Artist artist = new Artist();
        //when
        artist.setName(expected);
        String actual = artist.getName();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetBirthPlace() {
        //given
        String expected = "New York";
        Artist artist = new Artist(1L, "Edward Hopper", "New York", 1882);
        //when
        String actual = artist.getInstrument();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetBirthPlace() {
        //given
        String expected = "New York";
        Artist artist = new Artist();
        //when
        artist.setInstrument(expected);
        String actual = artist.getInstrument();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetBirthYear() {
        //given
        Integer expected = 1882;
        Artist artist = new Artist(1L, "Edward Hopper", "New York", 1882);
        //when
        Integer actual = artist.getAge();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetBirthYear() {
        //given
        Integer expected = 1882;
        Artist artist = new Artist();
        //when
        artist.setAge(expected);
        Integer actual = artist.getAge();
        //then
        Assert.assertEquals(expected, actual);
    }
}