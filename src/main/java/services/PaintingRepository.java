package services;

import entities.Painting;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaintingRepository implements Repository{

    private Connection connection;

    public PaintingRepository(Connection connection) {
        this.connection = connection;
    }
    public Connection getConnection() {
        return connection;
    }

    public void create(Painting painting) {
        executeStatement(String.format(new StringBuilder()
                        .append("INSERT INTO artdb.paintings(")
                        .append("id, title, medium, artist)")
                        .append("VALUES (%s, '%s', '%s', '%s');")
                        .toString(),
                painting.getId(),
                painting.getTitle(),
                painting.getMedium(),
                painting.getArtist()));
    }

    public List<Painting> findAll() {
        ResultSet resultSet = executeQuery("SELECT * FROM artdb.paintings;");
        List<Painting> list = new ArrayList<>();
        try {
            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String title = resultSet.getString(2);
                String medium = resultSet.getString(3);
                String artist = resultSet.getString(4);
                list.add(new Painting(
                        Long.parseLong(id),
                        title,
                        medium,
                        artist));
            }
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
        return list;
    }

    public Painting findById(Long id) {
        return findAll()
                .stream()
                .filter(painting -> painting.getId().equals(id))
                .findAny()
                .get();
    }

    public void update(Long id, Painting newPaintingData) {
        executeStatement(String.format(new StringBuilder()
                        .append("UPDATE artdb.paintings ")
                        .append("SET title = '%s', medium = '%s', artist = '%s' WHERE id = %s;")
                        .toString(),
                newPaintingData.getTitle(),
                newPaintingData.getMedium(),
                newPaintingData.getArtist(),
                id));
    }

    public void delete(Long id) {
        Painting painting = findById(id);
        executeStatement(String.format(new StringBuilder()
                        .append("DELETE FROM artdb.paintings WHERE id = %s")
                        .toString(),
                id));
        System.out.printf("%s has been deleted", painting.toString());
    }

    public void delete(Painting painting) {
        Long id = painting.getId();
        delete(id);
    }
}
