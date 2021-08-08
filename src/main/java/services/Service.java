package services;

import javax.persistence.*;


public interface Service {

    @PersistenceUnit
    EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("myunit");
    @PersistenceContext
    EntityManager entityManager = managerFactory.createEntityManager();

}

