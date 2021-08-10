package services;

import entities.Album;
import java.util.List;

public class AlbumService implements Service {


    public void create(Album album) {
        entityManager.getTransaction().begin();
        entityManager.persist(album);
        entityManager.getTransaction().commit();
    }

    public void createMultiple(List<Album> list) {
        entityManager.getTransaction().begin();
        list.stream()
                .forEach(album -> entityManager.persist(album));
        entityManager.getTransaction().commit();
    }

    public List<Album> findAll() {
        return entityManager.createQuery("SELECT p FROM Painting p", Album.class).getResultList();
    }

    public Album findById(Long id) {
        Album album = entityManager.find(Album.class, id);
        return album;
    }

    public void update(Long id, Album newAlbumData) {
        entityManager.getTransaction().begin();
        Album album = entityManager.find(Album.class, id);

        album.setId(newAlbumData.getId());
        album.setTitle(newAlbumData.getTitle());
        album.setGenre(newAlbumData.getGenre());
        album.setArtistName(newAlbumData.getArtistName());

        entityManager.getTransaction().commit();
    }

    public void delete(Long id) {
        Album album = entityManager.find(Album.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(album);
        entityManager.getTransaction().commit();
        System.out.printf("%s has been deleted", album.toString());
    }

    public void delete(Album album) {
        entityManager.getTransaction().begin();
        entityManager.remove(album);
        entityManager.getTransaction().commit();
        System.out.printf("%s has been deleted", album.toString());
    }
}
