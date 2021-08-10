package services;

import entities.Album;
import entities.Artist;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;

public class ArtistServ {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("AlbumDB");
    EntityManager entityManager = entityManagerFactory.createEntityManager();


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
        artist.setStageName(newArtistData.getStageName());
        artist.setNumOfAwards(newArtistData.getNumOfAwards());

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

//    // getAllBooks()
//    public List<Album> getBooks(Long id) {
//        Artist artist = em.find(Artist.class, id);
//        em.detach(artist);
//        List<Album> booksWritten = artist.getAlbum();
//        return booksWritten;
//    }
//
//    // findById()
//    public Artist findArtist(Long id) {
//        Artist artist = em.find(Artist.class, new Long(id));
//        em.detach(artist);
//        return artist;
//    }
//
//    // findAll()
//    public Collection<Artist> findAllAuthors() {
//        Query query = em.createQuery("SELECT a FROM Author a");
//        return (Collection<Artist>) query.getResultList();
//    }
//
//    // update()
//    public void updateAuthor(Long id, Artist newArtist) {
//        Artist artistToUpdate = findArtist(id);
//        em.detach(artistToUpdate);
//
//        artistToUpdate.setName(newArtist.getName());
//        artistToUpdate.setStageName(newArtist.getStageName());
//        artistToUpdate.setNumOfAwards(newArtist.getNumOfAwards());
//
//        em.getTransaction().begin();
//        em.merge(artistToUpdate);
//        em.getTransaction().commit();
//    }
//
//    // create()
//    public Long createAuthor(Artist artist) {
//        em.getTransaction().begin();
//        em.persist(artist);
//        em.detach(artist);
//        em.getTransaction().commit();
//        return artist.getId();
//    }
//
//    // delete()
//    public void deleteAuthor(Long id) {
//        em.getTransaction().begin();
//        Artist artist = em.find(Artist.class, id);
//        em.remove(artist);
//        em.getTransaction().commit();
//    }




//
//
//    public Artist findById(Long id) {
//        return entityManager.find(Artist.class, id);
//
//    }
//    public List<Artist> findAll() {
//        return entityManager.createQuery("SELECT v FROM Artist v", Artist.class).getResultList();
//
//    }
//
//    public void update(Long id, Artist newArtistData) {
//        entityManager.getTransaction().begin();
//        Artist artist = entityManager.find(Artist.class, id);
//        artist.setId(newArtistData.getId());
//        artist.setName(newArtistData.getName());
//        artist.setNumOfAwards(newArtistData.getNumOfAwards());
//        artist.setStageName(newArtistData.getStageName());
//        entityManager.getTransaction().commit();
//    }
//
//
//
//    public Long create(Artist artist) {
//        entityManager.getTransaction().begin();
//        entityManager.persist(artist);
//        entityManager.detach(artist);
//        entityManager.getTransaction().commit();
//        return artist.getId();
//
//    }
//
//
//    public void delete(Long id) {
//        Artist artist = entityManager.find(Artist.class, id);
//        entityManager.getTransaction().begin();
//        entityManager.remove(artist);
//        entityManager.getTransaction().commit();
//        System.out.printf("%s has been deleted", artist.toString());
//    }
//
//    public void delete(Artist artist) {
//        entityManager.getTransaction().begin();
//        entityManager.remove(artist);
//        entityManager.getTransaction().commit();
//        System.out.printf("%s has been deleted", artist.toString());
//    }

