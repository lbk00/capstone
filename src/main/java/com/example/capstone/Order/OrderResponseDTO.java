package com.example.capstone.Order;

//주문 응답 처리 DTO

import com.example.capstone.Order.testProduct.ProductDTO;

import java.util.List;

public class OrderResponseDTO {

    private Long id;
    private List<ProductDTO> orderedProducts;
    private Integer totalPrice;
    private String state;


    public OrderResponseDTO(Long id, List<ProductDTO> orderedProducts, Integer totalPrice, String state) {
        this.id = id;
        this.orderedProducts = orderedProducts;
        this.totalPrice = totalPrice;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public List<ProductDTO> getOrderedProducts() {
        return orderedProducts;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    // 주문 상태 = 생성(CREATED), 배송중(SHIPPING), 완료(COMPLETED), 취소(CANCELED)
    public String getState() {
        return state;
    }

    public static OrderResponseDTO toDTO(Order order) {
        List<ProductDTO> orderedProductDtos = order.getOrderedProducts()
                .stream()
                .map(orderedProduct -> ProductDTO.toDTO(orderedProduct))
                .toList();

        OrderResponseDTO orderResponseDto = new OrderResponseDTO(
                order.getId(),
                orderedProductDtos,
                order.getTotalPrice(),
                order.getState());

        return orderResponseDto;
    }

}