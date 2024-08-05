package com.example.capstone.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl {

    //jpa레포지토리 등록
    private final OrderRepository ordersRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    // Business methods for Orders
    public OrderResponseDTO createOrder(OrderRequestDTO orderRequestDTO) {
        Order order = new Order(orderRequestDTO);
        ordersRepository.save(order);

        OrderResponseDTO orderResponseDTO = OrderResponseDTO.toDTO(order);
        return orderResponseDTO;
    }

}