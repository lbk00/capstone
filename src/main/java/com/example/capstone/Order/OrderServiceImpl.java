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
    //Response 주문서 생성 후 레포지토리에 저장
    public OrderResponseDTO createOrder(OrderRequestDTO orderRequestDTO) {
        //requestDTO를 가지고 order 생성
        Order order = new Order(orderRequestDTO);
        ordersRepository.save(order);
        // order를 가지고 responseDTO 생성 후 반환
        OrderResponseDTO orderResponseDTO = OrderResponseDTO.toDTO(order);
        return orderResponseDTO;
    }

}