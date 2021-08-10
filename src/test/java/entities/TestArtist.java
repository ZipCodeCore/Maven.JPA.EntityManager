package entities;

import org.junit.Assert;
import org.junit.Test;

public class TestArtist {

    @Test
    public void idTest(){
        //GIVEN
        Artist  artistA = new Artist(1L, "Amanda", "Milk", 123);
        Long expected = 1L;
        //WHEN
        Long actual = artistA.getId();
        //THEN
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void idTest2(){
        //given
        Artist artistB = new Artist();
        Long expected = 2L;
        //when
        artistB.setId(expected);
        Long actual = artistB.getId();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void nameTest(){
        //GIVEN
        Artist artist = new Artist();
        String expected = "jimin";
        //WHEN
        artist.setName(expected);
        String actual = artist.getName();
        //THEN
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void stageName(){
        //GIVEN
        Artist artist = new Artist();
        String expected = "suga";
        //WHEN
        artist.setStageName(expected);
        String actual = artist.getStageName();
        //THEN
    Assert.assertEquals(expected, actual);
    }

    @Test
    public void numOfAwards(){
        //Given
        Artist artist = new Artist(3L, "Ashley", "Halsey", 345);
        int expected = 345;
        //WHEN
        //artist.setNumOfAwards(expected);
        int actual = artist.getNumOfAwards();
        //THEN
        Assert.assertEquals(expected, actual);

    }
}
