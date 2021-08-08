package services;

import entities.Painting;
import java.util.List;

public class PaintingService implements Service {

    public List<Painting> list;


    public void create(Painting painting) {
        entityManager.getTransaction().begin();
        entityManager.persist(painting);
        entityManager.getTransaction().commit();

    }

    public void createMultiple(List<Painting> list) {
        entityManager.getTransaction().begin();
        list.stream()
                .forEach(painting -> entityManager.persist(painting));
        entityManager.getTransaction().commit();
    }

    public List<Painting> findAll() {
        return entityManager.createQuery("SELECT p FROM Painting p", Painting.class).getResultList();

    }

    public Painting findById(Long id) {
        Painting painting = entityManager.find(Painting.class, id);

        return painting;
    }

    public void update(Long id, Painting newPaintingData) {
        entityManager.getTransaction().begin();
        Painting painting = entityManager.find(Painting.class, id);

        painting.setId(newPaintingData.getId());
        painting.setTitle(newPaintingData.getTitle());
        painting.setMedium(newPaintingData.getMedium());
        painting.setArtist(newPaintingData.getArtist());

        entityManager.getTransaction().commit();

    }

    public void delete(Long id) {
        Painting painting = entityManager.find(Painting.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(painting);
        entityManager.getTransaction().commit();
        System.out.printf("%s has been deleted", painting.toString());

    }

    public void delete(Painting painting) {
        entityManager.getTransaction().begin();
        entityManager.remove(painting);
        entityManager.getTransaction().commit();
        System.out.printf("%s has been deleted", painting.toString());

    }
}
//
//    private Connection connection;
//
//    public PaintingRepository(Connection connection) {
//        this.connection = connection;
//    }
//    public Connection getConnection() {
//        return connection;
//    }
//
//    public void create(Painting painting) {
//        executeStatement(String.format(new StringBuilder()
//                        .append("INSERT INTO artdb.Painting(")
//                        .append("id, title, medium, artist)")
//                        .append("VALUES (%s, '%s', '%s', '%s');")
//                        .toString(),
//                painting.getId(),
//                painting.getTitle(),
//                painting.getMedium(),
//                painting.getArtist()));
//    }
//
//    public List<Painting> findAll() {
//        ResultSet resultSet = executeQuery("SELECT * FROM artdb.Painting;");
//        List<Painting> list = new ArrayList<>();
//        try {
//            while (resultSet.next()) {
//                String id = resultSet.getString(1);
//                String title = resultSet.getString(2);
//                String medium = resultSet.getString(3);
//                String artist = resultSet.getString(4);
//                list.add(new Painting(
//                        Long.parseLong(id),
//                        title,
//                        medium,
//                        artist));
//            }
//        } catch (SQLException throwables) {
//            throw new RuntimeException(throwables);
//        }
//        return list;
//    }
//
//    public Painting findById(Long id) {
//        return findAll()
//                .stream()
//                .filter(painting -> painting.getId().equals(id))
//                .findAny()
//                .get();
//    }
//
//    public void update(Long id, Painting newPaintingData) {
//        executeStatement(String.format(new StringBuilder()
//                        .append("UPDATE artdb.Painting ")
//                        .append("SET title = '%s', medium = '%s', artist = '%s' WHERE id = %s;")
//                        .toString(),
//                newPaintingData.getTitle(),
//                newPaintingData.getMedium(),
//                newPaintingData.getArtist(),
//                id));
//    }
//
//    public void delete(Long id) {
//        Painting painting = findById(id);
//        executeStatement(String.format(new StringBuilder()
//                        .append("DELETE FROM artdb.Painting WHERE id = %s")
//                        .toString(),
//                id));
//        System.out.printf("%s has been deleted", painting.toString());
//    }
//
//    public void delete(Painting painting) {
//        Long id = painting.getId();
//        delete(id);
//    }
//}
