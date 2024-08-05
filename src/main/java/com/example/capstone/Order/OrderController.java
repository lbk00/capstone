package com.example.capstone.Order;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderServiceImpl ordersService;

    public OrderController(OrderServiceImpl ordersService) {
        this.ordersService = ordersService;
    }

    //주문서 생성 api
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<OrderResponseDTO> createOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
        OrderResponseDTO orderResponseDTO = ordersService.createOrder(orderRequestDTO);
        return ResponseEntity.ok(orderResponseDTO);
    }

    // Endpoints for Orders
}