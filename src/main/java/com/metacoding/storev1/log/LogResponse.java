package com.metacoding.storev1.log;

import lombok.Data;

// LogListResponseDTO

// DTO : Data Transfer Object -> 의역 : 화면에 필요한 데이터만 있는 오브젝트 (최종적으로 뜰채 같은 역할, 채에 걸러서 필요한 데이터만 주는 역할)
public class LogResponse {

    @Data // getter, setter, toString 보유한 친구
    public static class ListPage {
        private int id;
        private String name;
        private int qty;
        private int totalPrice;
        private String buyer;

        public ListPage(int id, String name, int qty, int totalPrice, String buyer) {
            this.id = id;
            this.name = name;
            this.qty = qty;
            this.totalPrice = totalPrice;
            this.buyer = buyer;
        }
    }

}
