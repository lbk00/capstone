package com.example.capstone.Order;

import com.example.capstone.Order.testProduct.Product;

import java.util.List;

public interface OrderService {

    OrderResponseDTO createOrder(List<OrderProductRequestDTO> orderProductRequestDtos);
    List<Product> makeOrderedProducts(List<OrderProductRequestDTO> orderProductRequestDtos);
    void decreaseProductAmount(List<Product> orderedProducts);

}
