package entities;

import org.junit.Assert;
import org.junit.Test;

public class TestAlbum {

@Test
    public void nameTest(){
    Album album = new Album(1L, "MOTS7", 20, 22);
    String expected = "MOTS7";

    String actual = album.getName();

    Assert.assertEquals(expected, actual);
}

@Test
    public void setNameTest(){
    Album album1 = new Album();
    String expected = "Persona";

    album1.setName(expected);
    String actual = album1.getName();

    Assert.assertEquals(expected, actual);
}

@Test
    public void idTest(){
    Album album = new Album(7L, "BE", 8, 35 );
    Long expected = 7L;

    Long actual = album.getId();

    Assert.assertEquals(expected, actual);
}

@Test
    public void setIdTest(){
    Album album = new Album();
    Long expected = 2L;

    album.setId(expected);
    Long actual = album.getId();

    Assert.assertEquals(expected, actual);


}

@Test
    public void numOfSongs(){
    Album album = new Album(2L, "TEAR", 11, 19);
    int expected = 11;

    int actual = album.getNumberOfSongs();

    Assert.assertEquals(expected, actual);
}

@Test
    public void setNumOfSongs(){
    Album album = new Album();
    int expected = 12;

    album.setNumberOfSongs(expected);
    int actual = album.getNumberOfSongs();

    Assert.assertEquals(expected, actual);


}

@Test
    public void price(){
    Album album = new Album(2L, "Answer", 16, 22);
    int expected = 22;

    int actual = album.getPrice();

    Assert.assertEquals(expected, actual);
}

@Test
    public void setPriceTest(){

    Album album = new Album();
    int expected = 23;

    album.setPrice(expected);
    int actual = album.getPrice();

    Assert.assertEquals(expected, actual);
}

}
