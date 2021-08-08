package services;

import javax.persistence.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public interface Service {

    @PersistenceUnit
    EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("myunit");
    @PersistenceContext
    EntityManager entityManager = managerFactory.createEntityManager();

}

