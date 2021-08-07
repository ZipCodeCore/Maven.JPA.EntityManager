package main;

import entities.Artist;
import entities.Painting;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class NewMainApp {

    public static void main(String[] args) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("myunit");
        EntityManager entityManager = managerFactory.createEntityManager();
        Artist artist = entityManager.find(Artist.class, 1L);
        Painting painting = entityManager.find(Painting.class, 1L);

        System.out.println(artist);
        System.out.println(painting);
    }
}
