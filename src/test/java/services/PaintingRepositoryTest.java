package services;

import entities.Painting;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class PaintingRepositoryTest {

    @Test
    public void testCreate() {
        //given
        Painting painting = new Painting(1L, "Nighthawks", "oil", "Edward Hopper");
        String expected = painting.toString();
        //when
        Connection connection = main.SQLConnect.getConnection("mysql");
        PaintingRepository paintingRepository = new PaintingRepository(connection);
        paintingRepository.create(painting);
        Painting painting1 = paintingRepository.findById(1L);
        String actual = painting1.toString();
        //then
        Assert.assertEquals(expected, actual);
        paintingRepository.delete(1L);
    }

    @Test
    public void testFindAll() {
        //given
        Painting painting1 = new Painting(1L, "Nighthawks", "oil", "Edward Hopper");
        Painting painting2 = new Painting(2L, "Almond Blossom", "oil", "Vincent van Gogh");
        List<Painting> list = new ArrayList<>();
        list.add(painting1);
        list.add(painting2);
        String expected = list.toString();
        //when
        Connection connection = main.SQLConnect.getConnection("mysql");
        PaintingRepository paintingRepository = new PaintingRepository(connection);
        paintingRepository.create(painting1);
        paintingRepository.create(painting2);
        String actual = paintingRepository.findAll().toString();
        //then
        Assert.assertEquals(expected, actual);
        paintingRepository.delete(1L);
        paintingRepository.delete(2L);
    }

    @Test
    public void testFindById() {
        //given
        Painting painting = new Painting(1L, "Nighthawks", "oil", "Edward Hopper");
        String expected = painting.toString();
        //when
        Connection connection = main.SQLConnect.getConnection("mysql");
        PaintingRepository paintingRepository = new PaintingRepository(connection);
        paintingRepository.create(painting);
        Painting painting1 = paintingRepository.findById(1L);
        String actual = painting1.toString();
        //then
        Assert.assertEquals(expected, actual);
        paintingRepository.delete(1L);
    }

    @Test
    public void testUpdate() {
        //given
        Painting painting = new Painting(1L, "Nighthawks", "oil", "Edward Hopper");
        Painting newPainting = new Painting(1L, "Almond Blossom", "oil", "Vincent van Gogh");
        String expected = newPainting.toString();
        //when
        Connection connection = main.SQLConnect.getConnection("mysql");
        PaintingRepository paintingRepository = new PaintingRepository(connection);
        paintingRepository.create(painting);
        paintingRepository.update(1L, newPainting);
        Painting painting1 = paintingRepository.findById(1L);
        String actual = painting1.toString();
        //then
        Assert.assertEquals(expected, actual);
        paintingRepository.delete(1L);
    }

    @Test
    public void testDeleteByID() {
        //given
        Painting painting1 = new Painting(1L, "Nighthawks", "oil", "Edward Hopper");
        Painting painting2 = new Painting(2L, "Almond Blossom", "oil", "Vincent van Gogh");
        int expected = 1;
        //when
        Connection connection = main.SQLConnect.getConnection("mysql");
        PaintingRepository paintingRepository = new PaintingRepository(connection);
        paintingRepository.create(painting1);
        paintingRepository.create(painting2);
        paintingRepository.delete(2L);
        int actual = paintingRepository.findAll().size();
        //then
        Assert.assertEquals(expected, actual);
        paintingRepository.delete(1L);
    }

    @Test
    public void testDeleteByObject() {
        //given
        Painting painting1 = new Painting(1L, "Nighthawks", "oil", "Edward Hopper");
        Painting painting2 = new Painting(2L, "Almond Blossom", "oil", "Vincent van Gogh");
        int expected = 1;
        //when
        Connection connection = main.SQLConnect.getConnection("mysql");
        PaintingRepository paintingRepository = new PaintingRepository(connection);
        paintingRepository.create(painting1);
        paintingRepository.create(painting2);
        paintingRepository.delete(painting2);
        int actual = paintingRepository.findAll().size();
        //then
        Assert.assertEquals(expected, actual);
        paintingRepository.delete(1L);
    }
}
