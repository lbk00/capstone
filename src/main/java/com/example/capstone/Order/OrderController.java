package com.example.capstone.Order;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderServiceImpl ordersService;

    public OrderController(OrderServiceImpl ordersService) {
        this.ordersService = ordersService;
    }

    //주문서 생성 api

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<OrderResponseDTO> createOrder(@RequestBody List<OrderProductRequestDTO> orderProductRequestDtos) {
        //상품 번호 리스트로 입력 받고 , 해당 정보를 가지고있는 주문서 생성
        OrderResponseDTO orderResponseDto = ordersService.createOrder(orderProductRequestDtos);
        return ResponseEntity.ok(orderResponseDto);
    }



    //주문서 목록 조회 api

    //주문번호로 조회 api

    // Endpoints for Orders
}