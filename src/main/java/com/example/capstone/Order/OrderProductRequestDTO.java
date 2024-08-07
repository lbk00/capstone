package com.example.capstone.Order;


// 주문 요청을 처리하는 DTO
public class OrderProductRequestDTO {
    private Long id;
    private Integer amount;

    public Long getId() {
        return id;
    }

    public Integer getAmount() {
        return amount;
    }
}
