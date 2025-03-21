package com.metacoding.storev1.log;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.ArrayList;
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

    // *로 하면 랜덤한 순서로 나옴
    public List<LogResponse.ListPage> findAllJoinStore() {
        List<LogResponse.ListPage> logList = new ArrayList<>();
        String q = "SELECT lt.id, st.name, lt.qty, lt.total_price, lt.buyer FROM log_tb lt INNER JOIN store_tb st ON lt.store_id = st.id ORDER BY lt.id DESC";
        Query query = em.createNativeQuery(q);
        List<Object[]> obsList = (List<Object[]>) query.getResultList(); // Object[] -> ROW

        // Mapping 오브젝트의 책임
        // ObjectMapping OM
        for (Object[] obs : obsList) {
            LogResponse.ListPage log = new LogResponse.ListPage(
                    (int) obs[0], (String) obs[1], (int) obs[2], (int) obs[3], (String) obs[4]);
            logList.add(log);
        }
        return logList;
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
