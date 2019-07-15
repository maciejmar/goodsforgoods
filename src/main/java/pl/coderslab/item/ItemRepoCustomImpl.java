package pl.coderslab.item;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.item.ItemRepoCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
@Transactional
public class ItemRepoCustomImpl implements ItemRepoCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void resetRating(int rating) {
        Query query = entityManager.createQuery("update Item b set b.rating = :rating");
        query.setParameter("rating", rating);
        query.executeUpdate();
    }
}

