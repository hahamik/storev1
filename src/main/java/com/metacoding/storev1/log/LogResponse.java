package com.metacoding.storev1.log;

import lombok.AllArgsConstructor;
import lombok.Data;

// DTO : Data Transfer Object -> 화면에 필요한 데이터만 있는 오브젝트트
public class LogResponse {

    @AllArgsConstructor
    @Data // getter, setter, toString
    public static class ListPage {
        private int id;
        private String name;
        private int qty;
        private int totalPrice;
        private String buyer;
    }
}