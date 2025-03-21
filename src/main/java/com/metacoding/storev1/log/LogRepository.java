package com.metacoding.storev1.log;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

import org.springframework.boot.autoconfigure.ssl.JksSslBundleProperties.Store;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class LogRepository {

    private EntityManager em;

    public LogRepository(EntityManager em) {
        this.em = em;

    }

    public void findAllJoinStore() {
        String q = "SELECT lt.id, st.name, lt.qty, lt.total_price, lt.buyer  FROM log_tb lt INNER JOIN store_tb st ON lt.store_id = st.id ORDER BY lt.id DESC";
        Query query = em.createNativeQuery(q);
        List<Object[]> obsList = (List<Object[]>) query.getResultList(); // Object[] -> ROW

        for (Object[] obs : obsList) {
            System.out.print(obs[0] + " ");
            System.out.print(obs[1] + " ");
            System.out.print(obs[2] + " ");
            System.out.print(obs[3] + " ");
            System.out.print(obs[4] + " ");
            System.out.println("=========");
        }

    }

    // @Transactional
    // public void save(String buyer, int stock, int price) {
    // Query query = em.createNativeQuery("insert into log_tb(name, stock, price)
    // values(?,?,?)");
    // query.setParameter(1, buyer);
    // query.setParameter(2, stock);
    // query.setParameter(3, price);
    // query.executeUpdate();
    // }

}
