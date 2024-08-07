package com.example.capstone.Order;

import com.example.capstone.Order.testProduct.Product;

import java.util.List;

public interface OrderService {

    public OrderResponseDTO createOrder(List<OrderProductRequestDTO> orderProductRequestDtos);
    public List<Product> makeOrderedProducts(List<OrderProductRequestDTO> orderProductRequestDtos);
    public void decreaseProductAmount(List<Product> orderedProducts);

}
