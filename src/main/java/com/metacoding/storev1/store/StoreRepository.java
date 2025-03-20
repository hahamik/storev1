package com.metacoding.storev1.store;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
// import lombok.AllArgsConstructor;
// import lombok.RequiredArgsConstructor;
import jakarta.persistence.Query;

// @RequiredArgsConstructor //final 붙은 필드로만 생성자 만들어
//@AllArgsConstructor
@Repository
public class StoreRepository {

    private EntityManager em;

    public StoreRepository(EntityManager em) {
        this.em = em;
    }

    public void save(String name, int stock, int price) {
        Query query = em.createNativeQuery("insert into store_tb(name,stock,price) values(?,?,?)"); // 자카르타 query
        query.setParameter(1, name);
        query.setParameter(2, stock);
        query.setParameter(3, price);
        query.executeUpdate(); // insert, update, delete
    }

    public List<Store> findAll() {
        // 조건 : Object Mapping 은 @Entity 가 붙어있어야지만 가능하다.<디폴트 생성자를 호출>
        // setter 가 없어도 들어가는 이유는?? -> 리플렉션 (setAccessible을 통해)
        Query query = em.createNativeQuery("select * from store_tb order by id desc", Store.class);
        return query.getResultList();
    }
}
