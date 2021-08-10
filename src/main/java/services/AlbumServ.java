package services;

import entities.Album;
import entities.Artist;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AlbumServ {


    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("AlbumDB");
    EntityManager entityManager = entityManagerFactory.createEntityManager();


    public Album findById(Long id) {
        return entityManager.find(Album.class, id);

    }
    public List<Album> findAll() {
        return entityManager.createQuery("SELECT v FROM Album v", Album.class).getResultList();

    }

    public void update(Long id, Album newAlbumData) {
        entityManager.getTransaction().begin();
        Album album = entityManager.find(Album.class, id);
        album.setId(newAlbumData.getId());
        album.setName(newAlbumData.getName());
        album.setNumberOfSongs(newAlbumData.getNumberOfSongs());
        album.setPrice(newAlbumData.getPrice());
        entityManager.getTransaction().commit();
    }



    public void create(Album album) {
        entityManager.getTransaction().begin();
        entityManager.persist(album);
        entityManager.getTransaction().commit();

    }


    public void delete(Long id) {
        Album album = entityManager.find(Album.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(album);
        entityManager.getTransaction().commit();

    }

    public void delete(Album album) {
        entityManager.getTransaction().begin();
        entityManager.remove(album);
        entityManager.getTransaction().commit();
    }


}


// <property name="hibernate.dialect" value="org.hibernate.dialect.MySQL5Dialect"/>
// <property name="hibernate.hbm2ddl.auto" value="update"/>