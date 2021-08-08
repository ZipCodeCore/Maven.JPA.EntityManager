package services;

import entities.Artist;
import entities.Painting;
import java.util.List;

public class PaintingService implements Service {


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
        painting.setArtistName(newPaintingData.getArtistName());

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
