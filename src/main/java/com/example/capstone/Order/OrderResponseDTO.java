package com.example.capstone.Order;

//주문 응답 처리 DTO

import com.example.capstone.Order.testProduct.ProductDTO;
import lombok.Getter;

import java.util.List;

@Getter
public class OrderResponseDTO {

    private Long id;
    private List<ProductDTO> orderedProducts;
    private Integer totalPrice;
    private OrderType orderType;


    public OrderResponseDTO(Long id, List<ProductDTO> orderedProducts, Integer totalPrice, OrderType orderType) {
        this.id = id;
        this.orderedProducts = orderedProducts;
        this.totalPrice = totalPrice;
        this.orderType = orderType;
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
                order.getOrderType());

        return orderResponseDto;
    }

}