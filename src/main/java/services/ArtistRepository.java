package services;

import entities.Artist;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArtistRepository implements Repository{

//    private Connection connection;

//    public ArtistRepository(Connection connection) {
//        this.connection = connection;
//    }
//    public Connection getConnection() {
//        return connection;
//    }

    public void create(Artist artist) {
        entityManager.getTransaction().begin();
        entityManager.persist(artist);
        entityManager.getTransaction().commit();
//        executeStatement(String.format(new StringBuilder()
//                        .append("INSERT INTO artdb.Artist(")
//                        .append("id, name, birthPlace, birthYear)")
//                        .append("VALUES (%s, '%s', '%s', %s);")
//                        .toString(),
//                artist.getId(),
//                artist.getName(),
//                artist.getBirthPlace(),
//                artist.getBirthYear()));
    }

    public List<Artist> findAll() {
//        ResultSet resultSet = executeQuery("SELECT * FROM artdb.Artist;");
//        List<Artist> list = new ArrayList<>();
//        try {
//            while (resultSet.next()) {
//                String id = resultSet.getString(1);
//                String name = resultSet.getString(2);
//                String birthplace = resultSet.getString(3);
//                String birthyear = resultSet.getString(4);
//                list.add(new Artist(
//                        Long.parseLong(id),
//                        name,
//                        birthplace,
//                        Integer.parseInt(birthyear)));
//            }
//        } catch (SQLException throwables) {
//            throw new RuntimeException(throwables);
//        }
//        return list;
        return null;
    }

    public Artist findById(Long id) {
        Artist artist = entityManager.find(Artist.class, id);
//        return findAll()
//                .stream()
//                .filter(artist -> artist.getId().equals(id))
//                .findAny()
//                .get();
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
//        executeStatement(String.format(new StringBuilder()
//                        .append("UPDATE artdb.Artist ")
//                        .append("SET name = '%s', birthPlace = '%s', birthYear = %s WHERE id = %s;")
//                        .toString(),
//                newArtistData.getName(),
//                newArtistData.getBirthPlace(),
//                newArtistData.getBirthYear(),
//                id));
    }

    public void delete(Long id) {
        Artist artist = entityManager.find(Artist.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(artist);
        entityManager.getTransaction().commit();
        System.out.printf("%s has been deleted", artist.toString());
//        Artist artist = findById(id);
//        executeStatement(String.format(new StringBuilder()
//                        .append("DELETE FROM artdb.Artist WHERE id = %s")
//                        .toString(),
//                id));
//        System.out.printf("%s has been deleted", artist.toString());
    }

    public void delete(Artist artist) {
        entityManager.getTransaction().begin();
        entityManager.remove(artist);
        entityManager.getTransaction().commit();
        System.out.printf("%s has been deleted", artist.toString());
//        Long id = artist.getId();
//        delete(id);
    }
}
