// This is the SearchRepository class

package com.keyin.sprint2.repository;
import com.keyin.sprint2.model.Search;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class SearchRepository {
    @PersistenceContext
    private EntityManager entityManager;


    // Insert into databse
    @Transactional
    public void insertWithQuery(Search search) {
        entityManager.createNativeQuery("INSERT INTO search (id, topic, database) VALUES (?,?,?)")
                .setParameter(1, search.getId())
                .setParameter(2, search.getTopic())
                .setParameter(3, search.getDatabase())
                .executeUpdate();
    }

    @Transactional
    public void insertWithEntityManager(Search search) {
        this.entityManager.persist(search);
    }
}
