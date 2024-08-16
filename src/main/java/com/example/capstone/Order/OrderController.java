package com.example.capstone.Order;

import org.springframework.http.HttpStatus;
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
        OrderResponseDTO orderResponseDTO = ordersService.orderDetail(id);
        return ResponseEntity.ok(orderResponseDTO);
    }

    //특정 카테고리 주문서 정보 조회 api
    @RequestMapping(value = "category/{id}", method = RequestMethod.GET)
    public ResponseEntity<OrderListResponseDTO> orderCategory(@PathVariable("id") Long id) {
        // 해당 카테고리에 속하는 주문서들만 조회
        OrderListResponseDTO orderListResponseDTO = ordersService.orderCategory(id);
        return ResponseEntity.ok(orderListResponseDTO);
    }

    //주문서 수정
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<OrderResponseDTO> updateOrder(
            @PathVariable("id") Long id,
            @RequestBody OrderDTO orderDTO) {

        OrderResponseDTO orderResponseDTO = ordersService.orderUpdate(id,orderDTO);
        // 수정된 주문서 반환
        // 현재 구현된 기능은 입력된 정보 그대로 수정됨
        // -> 상품 id와 수량 입력후 , 해당 수량이 있는지 / 총 가격 계산하는 기능 추가해야함
        return ResponseEntity.ok(orderResponseDTO);

    }

    //주문서 삭제
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteOrder(@PathVariable("id") Long id) {
        ordersService.deleteOrder(id);
        return new ResponseEntity<>("Order deleted successfully", HttpStatus.OK);
    }

    // Endpoints for Orders
}