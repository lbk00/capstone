package com.example.capstone.Order;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<OrderListResponseDTO> orderList() {
        OrderListResponseDTO orderListResponseDTO = ordersService.orderList();
        return ResponseEntity.ok(orderListResponseDTO);
    }

    //주문서번호로 조회 api
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<OrderResponseDTO> orderDetail(@PathVariable("id") Long id) {
        //주문서의 번호를 입력 받고, 해당 주문서의 정보를 출력
        OrderResponseDTO orderResponseDto = ordersService.orderDetail(id);
        return ResponseEntity.ok(orderResponseDto);
    }


    // Endpoints for Orders
}