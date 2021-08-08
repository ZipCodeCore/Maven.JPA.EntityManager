package services;

import entities.Artist;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import java.util.List;

public class ArtistService implements Service {


    public void create(Artist artist) {
        entityManager.getTransaction().begin();
        entityManager.persist(artist);
        entityManager.getTransaction().commit();
    }

    public void createMultiple(List<Artist> list) {
        entityManager.getTransaction().begin();
        list.stream()
                .forEach(artist -> entityManager.persist(artist));
        entityManager.getTransaction().commit();
    }

    public List<Artist> findAll() {
        return entityManager.createQuery("SELECT a FROM Artist a", Artist.class).getResultList();
    }

    public Artist findById(Long id) {
        Artist artist = entityManager.find(Artist.class, id);
        return artist;
    }

    public void update(Long id, Artist newArtistData) {
        entityManager.getTransaction().begin();
        Artist artist = entityManager.find(Artist.class, id);

        artist.setId(newArtistData.getId());
        artist.setName(newArtistData.getName());
        artist.setBirthPlace(newArtistData.getBirthPlace());
        artist.setBirthYear(newArtistData.getBirthYear());

        entityManager.getTransaction().commit();
    }

    public void delete(Long id) {
        Artist artist = entityManager.find(Artist.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(artist);
        entityManager.getTransaction().commit();
        System.out.printf("%s has been deleted", artist.toString());
    }

    public void delete(Artist artist) {
        entityManager.getTransaction().begin();
        entityManager.remove(artist);
        entityManager.getTransaction().commit();
        System.out.printf("%s has been deleted", artist.toString());
    }
}
