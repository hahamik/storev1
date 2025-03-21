package com.metacoding.storev1.log;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class LogRepository {

    private EntityManager em;

    public LogRepository(EntityManager em) {
        this.em = em;

    }

    public void findAll() {
        Query query = em.createNativeQuery(
                "SELECT lt.id, st.name, lt.qty, lt.total_price, lt.buyer " +
                        "FROM log_tb lt LEFT JOIN store_tb st ON lt.store_id = st.id " +
                        "ORDER BY lt.id DESC");
        query.getResultList();

    }

    @Transactional
    public void save(String buyer, int stock, int price) {
        Query query = em.createNativeQuery("insert into log_tb(name, stock, price) values(?,?,?)");
        query.setParameter(1, buyer);
        query.setParameter(2, stock);
        query.setParameter(3, price);
        query.executeUpdate();
    }

}
