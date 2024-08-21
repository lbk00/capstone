package com.example.capstone.Order;

import com.example.capstone.Order.testProduct.Product;

import java.util.List;

public interface OrderService {

    // 고객용 상품 주문 메서드
    OrderResponseDTO purchase(List<OrderProductRequestDTO> orderProductRequestDtos);
    // 주문서 생성 메서드
    OrderResponseDTO createOrder(List<OrderProductRequestDTO> orderProductRequestDtos);
    // 상품이 주문 수량만큼 재고가 있는지 확인하는 메서드
    List<Product> makeOrderedProducts(List<OrderProductRequestDTO> orderProductRequestDtos);
    // 상품 수량을 감소시키는 메서드
    void decreaseProductAmount(List<Product> orderedProducts);
    // 상품 수량을 증가시키는 메서드
    void increaseProductAmount(List<Product> orderedProducts);
    // 주문서를 납품완료로 바꿔주는 메서드
    OrderResponseDTO complete(Long id);
    //특정 주문서를 조회하는 메서드
    OrderResponseDTO orderDetail(Long id);
    //주문서 목록 조회하는 메서드
    OrderListResponseDTO orderList();
    //특정 카테고리의 주문서를 조회하는 메서드
    OrderListResponseDTO orderCategory(Long id);
    //주문서 삭제 메서드
    void deleteOrder(Long id);
    //주문서 수정 메서드
    OrderResponseDTO orderUpdate(Long id,OrderDTO orderDTO);
}
