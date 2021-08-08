package entities;

import org.junit.Assert;
import org.junit.Test;

public class PaintingTest {

    @Test
    public void testGetId() {
        //given
        Long expected = 1L;
        Painting painting = new Painting(1L, "Nighthawks", "oil", "Edward Hopper");
        //when
        Long actual = painting.getId();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetId() {
        //given
        Long expected = 1L;
        Painting painting = new Painting();
        //when
        painting.setId(expected);
        Long actual = painting.getId();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetTitle() {
        //given
        String expected = "Nighthawks";
        Painting painting = new Painting(1L, "Nighthawks", "oil", "Edward Hopper");
        //when
        String actual = painting.getTitle();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetTitle() {
        //given
        String expected = "Nighthawks";
        Painting painting = new Painting();
        //when
        painting.setTitle(expected);
        String actual = painting.getTitle();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetMedium() {
        //given
        String expected = "oil";
        Painting painting = new Painting(1L, "Nighthawks", "oil", "Edward Hopper");
        //when
        String actual = painting.getMedium();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetMedium() {
        //given
        String expected = "oil";
        Painting painting = new Painting();
        //when
        painting.setMedium(expected);
        String actual = painting.getMedium();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetArtist() {
        //given
        String expected = "Edward Hopper";
        Painting painting = new Painting(1L, "Nighthawks", "oil", "Edward Hopper");
        //when
        String actual = painting.getArtistName();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetArtist() {
        //given
        String expected = "Edward Hopper";
        Painting painting = new Painting();
        //when
        painting.setArtistName(expected);
        String actual = painting.getArtistName();
        //then
        Assert.assertEquals(expected, actual);
    }
}