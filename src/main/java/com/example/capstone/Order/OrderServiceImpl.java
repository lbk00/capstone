package com.example.capstone.Order;

import com.example.capstone.Order.testProduct.Product;
import com.example.capstone.Order.testProduct.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {


    //jpa레포지토리 등록
    private final OrderRepository ordersRepository;
    private final ProductRepository productRepository;
    //임시 레포지토리
    //private final ListProductRepository productRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository ordersRepository, ProductRepository productRepository) {
        this.ordersRepository = ordersRepository;
        //this.productRepository = productRepository;
        this.productRepository = productRepository;
    }

    // Business methods for Orders
    //Response 주문서 생성 후 레포지토리에 저장
    @Override
    public OrderResponseDTO createOrder(List<OrderProductRequestDTO> orderProductRequestDtos) {
        //리스트로 받은 상품들의 id를 조회하여 주문서 생성
        List<Product> orderedProducts = makeOrderedProducts(orderProductRequestDtos);
        decreaseProductAmount(orderedProducts);
        //requestDTO를 가지고 order 생성
        Order order = new Order(orderedProducts);
        ordersRepository.save(order);
        // 주문서를 가지고 responseDTO 생성 후 반환
        OrderResponseDTO orderResponseDTO = OrderResponseDTO.toDTO(order);
        return orderResponseDTO;
    }


    // 상품이 주문 수량만큼 재고가 있는지 확인
    @Override
    public List<Product> makeOrderedProducts(List<OrderProductRequestDTO> orderProductRequestDtos) {
        return orderProductRequestDtos
                .stream()// 하나의 map 연산마다 Product를 조회
                .map(orderProductRequestDto -> {
                    Long productId = orderProductRequestDto.getId();
                    Product product = productRepository.findById(productId)
                            .orElseThrow(() -> new RuntimeException("Product not found: " + productId));

                    //Optional<Product> productOptional = productRepository.findById(productId);

                    Integer orderedAmount = orderProductRequestDto.getAmount();
                    product.checkEnoughAmount(orderedAmount);
                    // 재고가 충분한지 확인

                    //조회 후 Product 생성
                    return new Product(
                            productId,
                            product.getName(),
                            product.getPrice(),
                            orderProductRequestDto.getAmount()
                    );
                }).toList(); // 생성한 Product들로 리스트 생성
    }

    @Override
    public void decreaseProductAmount(List<Product> orderedProducts) {
        orderedProducts
                .stream()
                .forEach(orderedProduct -> {
                    Long productId = orderedProduct.getId();
                    Product product = productRepository.findById(productId)
                            .orElseThrow(() -> new RuntimeException("Product not found: " + productId));

                    Integer orderedAmount = orderedProduct.getAmount();
                    product.decreaseAmount(orderedAmount);

                    //엔티티가 데이터베이스에 이미 존재하면 업데이트하고, 존재하지 않으면 새로 삽입
                    productRepository.save(product);
                });
    }


    @Override
    public OrderResponseDTO orderDetail(Long id) {
        Optional<Order> order = ordersRepository.findById(id);
        OrderResponseDTO orderResponseDTO = OrderResponseDTO.toDTO(order.get());
        return orderResponseDTO;
    }

    @Override
    public OrderListResponseDTO orderList() {
        List<Order> orderList = ordersRepository.findAll();
        // 조회한 리스트들을 DTO 형태로 변경
        OrderListResponseDTO orderListResponseDTO = OrderListResponseDTO.toDTO(orderList);
        return orderListResponseDTO;
    }


    @Override
    public OrderListResponseDTO orderCategory(Long id) {
        //< 0 = 주문 전, 1 = 주문 중 , 2 = 납품(주문) 완료 , 3 = 반품 중 , 4 = 반품 완료 , 5 = 취소>
        // id 값에따라 특정 카테고리의 리스트 반환
        List<Order> list = null;
        if (id == 0) {
            list = ordersRepository.findByOrderType(OrderType.BEFORE_ORDER);
        } else if (id == 1) {
            list = ordersRepository.findByOrderType(OrderType.PROGRESS_ORDER);
        } else if (id == 2) {
            list = ordersRepository.findByOrderType(OrderType.COMPLETE_ORDER);
        } else if (id == 3) {
            list = ordersRepository.findByOrderType(OrderType.RETURNING);
        } else if (id == 4) {
            list = ordersRepository.findByOrderType(OrderType.COMPLETE_RETURN);
        } else if (id == 5) {
            list = ordersRepository.findByOrderType(OrderType.CANCELLED);
        }
        OrderListResponseDTO orderListResponseDTO = OrderListResponseDTO.toDTO(list);
        return orderListResponseDTO;

    }
}