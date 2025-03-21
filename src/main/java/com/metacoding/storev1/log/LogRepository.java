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
    public List<LogResponse.DTO> findAllJoinStore() {
        List<LogResponse.DTO> respDTOs = new ArrayList<>();
        String q = "SELECT lt.id, st.name, lt.qty, lt.total_price, lt.buyer FROM log_tb lt INNER JOIN store_tb st ON lt.store_id = st.id";
        Query query = em.createNativeQuery(q);
        List<Object[]> obsList = (List<Object[]>) query.getResultList(); // Object[] -> ROW

        for (Object[] obs : obsList) {
            LogResponse.DTO respDTO = new LogResponse.DTO(
                    (int) obs[0], (String) obs[1], (int) obs[2], (int) obs[3], (String) obs[4]);
            respDTOs.add(respDTO);
        }
        return respDTOs;
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
