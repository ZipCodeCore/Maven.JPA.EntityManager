package main;

import entities.Artist;
import entities.Painting;
import services.ArtistRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class NewMainApp {

    public static void main(String[] args) {

        ArtistRepository artistRepository = new ArtistRepository();

        Artist vanGogh = new Artist(1L, "Vincent van Gogh", "Netherlands", 1853);
        Artist hopper = new Artist(1L, "Edward Hopper", "New York", 1882);

        Painting almondBlossom = new Painting(1L, "Almond Blossom", "oil", "Vincent van Gogh");
        Painting nightHawks = new Painting(2L, "NightHawks", "oil", "Edward Hopper");

//        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("myunit");
//        EntityManager entityManager = managerFactory.createEntityManager();
//        Painting painting = entityManager.find(Painting.class, 1L);

        //CREATE
        artistRepository.create(vanGogh);
//        artistRepository.create(hopper);
//        entityManager.persist(almondBlossom);
//        entityManager.persist(nightHawks);
//        entityManager.getTransaction().commit();

        //READ
        Artist artist1 = artistRepository.findById(1L);
        System.out.println(artist1.toString());
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

        //UPDATE
        artistRepository.update(1L, hopper);
        System.out.println(artistRepository.findById(1L));

        //DELETE
        artistRepository.delete(1L);
    }
}
