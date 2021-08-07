package main;

import entities.Artist;
import entities.Painting;
import services.ArtistRepository;
import services.PaintingRepository;
import services.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class NewMainApp {

    public static void main(String[] args) {

        ArtistRepository artistRepository = new ArtistRepository();
        PaintingRepository paintingRepository = new PaintingRepository();
        List<Artist> artistList = new ArrayList<>();
        List<Painting> paintingList = new ArrayList<>();

        Artist vanGogh = new Artist(1L, "Vincent van Gogh", "Netherlands", 1853);
        Artist hopper = new Artist(2L, "Edward Hopper", "New York", 1882);
        artistList.add(vanGogh);
        artistList.add(hopper);

        Painting almondBlossom = new Painting(1L, "Almond Blossom", "oil", "Vincent van Gogh");
        Painting nightHawks = new Painting(2L, "NightHawks", "oil", "Edward Hopper");
        paintingList.add(almondBlossom);
        paintingList.add(nightHawks);

//        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("myunit");
//        EntityManager entityManager = managerFactory.createEntityManager();
//        Painting painting = entityManager.find(Painting.class, 1L);

        //CREATE
        artistRepository.createMultiple(artistList);
        paintingRepository.createMultiple(paintingList);
//        artistRepository.create(hopper);
//        entityManager.persist(almondBlossom);
//        entityManager.persist(nightHawks);
//        entityManager.getTransaction().commit();

        //READ
        Artist artist1 = artistRepository.findById(1L);
        Artist artist2 = artistRepository.findById(2L);
        System.out.println(artist1.toString());
        System.out.println(artist2.toString());

        Painting painting1 = paintingRepository.findById(1L);
        Painting painting2 = paintingRepository.findById(2L);
        System.out.println(painting1.toString());
        System.out.println(painting2.toString());
//        artistRepository.findById(2L);
//        Artist artist1 = entityManager.find(Artist.class, 1L);
//        Artist artist2 = entityManager.find(Artist.class, 2L);
//        System.out.println(artist1);
//        System.out.println(artist2);
//        Painting painting1 = entityManager.find(Painting.class, 1L);
//        Painting painting2 = entityManager.find(Painting.class, 2L);
//        System.out.println(painting1);
//        System.out.println(painting2);
//        System.out.println(painting);

//        //UPDATE
//        artistRepository.update(1L, hopper);
//        System.out.println(artistRepository.findById(1L));
//
//        //DELETE
//        artistRepository.delete(1L);
    }
}
