package services;

import entities.Artist;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArtistRepository implements Repository{
    private Connection connection;

    public ArtistRepository(Connection connection) {
        this.connection = connection;
    }
    public Connection getConnection() {
        return connection;
    }

    public void create(Artist artist) {
        executeStatement(String.format(new StringBuilder()
                        .append("INSERT INTO artdb.artists(")
                        .append("id, name, birthplace, birth_year)")
                        .append("VALUES (%s, '%s', '%s', %s);")
                        .toString(),
                artist.getId(),
                artist.getName(),
                artist.getBirthPlace(),
                artist.getBirthYear()));
    }

    public List<Artist> findAll() {
        ResultSet resultSet = executeQuery("SELECT * FROM artdb.artists;");
        List<Artist> list = new ArrayList<>();
        try {
            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String name = resultSet.getString(2);
                String birthplace = resultSet.getString(3);
                String birthyear = resultSet.getString(4);
                list.add(new Artist(
                        Long.parseLong(id),
                        name,
                        birthplace,
                        Integer.parseInt(birthyear)));
            }
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
        return list;
    }

    public Artist findById(Long id) {
        return findAll()
                .stream()
                .filter(artist -> artist.getId().equals(id))
                .findAny()
                .get();
    }

    public void update(Long id, Artist newArtistData) {
        executeStatement(String.format(new StringBuilder()
                        .append("UPDATE potions.potionsTable ")
                        .append("SET name = '%s', birthplace = '%s', birth_year = %s WHERE id = %s;")
                        .toString(),
                newArtistData.getName(),
                newArtistData.getBirthPlace(),
                newArtistData.getBirthYear(),
                id));
    }

    public void delete(Long id) {
        Artist artist = findById(id);
        executeStatement(String.format(new StringBuilder()
                        .append("DELETE FROM artdb.artists WHERE id = %s")
                        .toString(),
                id));
        System.out.printf("%s has been deleted", artist.toString());
    }

    public void delete(Artist artist) {
        Long id = artist.getId();
        delete(id);
    }
}
