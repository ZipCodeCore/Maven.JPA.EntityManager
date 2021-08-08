package services;

import entities.Artist;
import entities.Painting;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class PaintingServiceTest {

    PaintingService paintingService = new PaintingService();


    @Test
    public void testCreate() {
        //given
        Painting painting = new Painting(1L, "Almond Blossom", "oil", "Vincent van Gogh");
        String expected = painting.toString();
        //when
        paintingService.create(painting);
        Painting painting1 = paintingService.findById(1L);
        String actual = painting1.toString();
        //then
        Assert.assertEquals(expected, actual);
        paintingService.delete(painting);
    }

    @Test
    public void testFindAll() {
        //given
        Painting almondBlossom = new Painting(1L, "Almond Blossom", "oil", "Vincent van Gogh");
        Painting nightHawks = new Painting(2L, "NightHawks", "oil", "Edward Hopper");
        List<Painting> list = new ArrayList<>();
        list.add(almondBlossom);
        list.add(nightHawks);
        String expected = list.toString();
        //when
        paintingService.createMultiple(list);
        String actual = paintingService.findAll().toString();
        //then
        Assert.assertEquals(expected, actual);
        paintingService.delete(almondBlossom);
        paintingService.delete(nightHawks);
    }

    @Test
    public void testFindById() {
        //given
        Painting painting = new Painting(1L, "Almond Blossom", "oil", "Vincent van Gogh");
        String expected = painting.toString();
        //when
        paintingService.create(painting);
        Painting painting1 = paintingService.findById(1L);
        String actual = painting1.toString();
        //then
        Assert.assertEquals(expected, actual);
        paintingService.delete(painting);
    }

    @Test
    public void testUpdate() {
        //given
        Painting almondBlossom = new Painting(1L, "Almond Blossom", "oil", "Vincent van Gogh");
        Painting nightHawks = new Painting(1L, "NightHawks", "oil", "Edward Hopper");
        String expected = nightHawks.toString();
        //when
        paintingService.create(almondBlossom);
        paintingService.update(1L, nightHawks);
        Painting painting = paintingService.findById(1L);
        String actual = painting.toString();
        //then
        Assert.assertEquals(expected, actual);
        paintingService.delete(painting);
    }

    @Test
    public void testDeleteByID() {
        //given
        Painting almondBlossom = new Painting(1L, "Almond Blossom", "oil", "Vincent van Gogh");
        Painting nightHawks = new Painting(2L, "NightHawks", "oil", "Edward Hopper");
        List<Painting> list = new ArrayList<>();
        list.add(almondBlossom);
        list.add(nightHawks);
        int expected = 1;
        //when
        paintingService.createMultiple(list);
        paintingService.delete(2L);
        int actual = paintingService.findAll().size();
        //then
        Assert.assertEquals(expected, actual);
        paintingService.delete(1L);
    }

    @Test
    public void testDeleteByObject() {
        //given
        Painting almondBlossom = new Painting(1L, "Almond Blossom", "oil", "Vincent van Gogh");
        Painting nightHawks = new Painting(2L, "NightHawks", "oil", "Edward Hopper");
        List<Painting> list = new ArrayList<>();
        list.add(almondBlossom);
        list.add(nightHawks);
        int expected = 1;
        //when
        paintingService.createMultiple(list);
        paintingService.delete(nightHawks);
        int actual = paintingService.findAll().size();
        //then
        Assert.assertEquals(expected, actual);
        paintingService.delete(1L);
    }
}
