package com.example.capstone.Order;

//주문 요청 DTO

public class OrderRequestDTO {
    private Long id;
    private Integer totalPrice;
    private String state;

    public Long getId() {
        return id;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public String getState() {
        return state;
    }
}
