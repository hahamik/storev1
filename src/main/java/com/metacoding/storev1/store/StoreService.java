package com.metacoding.storev1.store;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StoreService {

    private StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Transactional
    public void 상품등록(String name, int stock, int price) {
        storeRepository.save(name, stock, price);
    }

    public List<Store> 상품목록() {
        List<Store> storeList = storeRepository.findAll();
        return storeList;
    }

    public Store 상세보기(int id) {
        return storeRepository.findById(id);

    }

    @Transactional
    public void 상품삭제(int id) {
        Store store = storeRepository.findById(id);
        if (store == null) {
            throw new RuntimeException("없는 상품입니다. 삭제 불가");
        }
        storeRepository.delete(id);
    }

    @Transactional
    public void 상품수정(int id, String name, int stock, int price) {
        // 1. 상품 조회
        Store store = storeRepository.findById(id);

        // 2. 없으면 예외처리
        if (store == null) {
            throw new RuntimeException("없는 상품입니다. 수정 불가");
        }

        // 3. 상품수정
        storeRepository.update(id, name, stock, price);
    }
}