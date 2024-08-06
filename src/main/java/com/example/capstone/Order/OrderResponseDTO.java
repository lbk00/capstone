package com.example.capstone.Order;

//주문 응답 처리 DTO

public class OrderResponseDTO {

    private Long id;
    private Integer totalPrice;
    private String state;


    public OrderResponseDTO(Long id, Integer totalPrice, String state) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public String getState() {
        return state;
    }

    public static OrderResponseDTO toDTO(Order order) {
        return new OrderResponseDTO(order.getId(), order.getTotalPrice(), order.getState());
    }

}