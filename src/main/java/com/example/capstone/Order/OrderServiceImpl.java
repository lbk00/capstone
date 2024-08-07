package com.example.capstone.Order;

import com.example.capstone.Order.testProduct.Product;
import com.example.capstone.Product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    //jpa레포지토리 등록
    private final OrderRepository ordersRepository;
    private final ProductRepository productRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository ordersRepository, ProductRepository productRepository) {
        this.ordersRepository = ordersRepository;
        this.productRepository = productRepository;
    }

    // Business methods for Orders
    //Response 주문서 생성 후 레포지토리에 저장
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
    //private -> public 임시 수정
    public List<Product> makeOrderedProducts(List<OrderProductRequestDTO> orderProductRequestDtos) {
        return orderProductRequestDtos
                .stream()// 하나의 map 연산마다 Product를 조회
                .map(orderProductRequestDto -> {
                    Long productId = orderProductRequestDto.getId();
                    Optional<Product> productOptional = productRepository.findById(productId);

                    Integer orderedAmount = orderProductRequestDto.getAmount();
                    productOptional.ifPresent(product -> {
                        product.checkEnoughAmount(orderedAmount);
                    }); // 재고가 충분한지 확인

                    //조회 후 Product 생성
                    return new Product(
                            productId,
                            productOptional.get().getName(),
                            productOptional.get().getPrice(),
                            orderProductRequestDto.getAmount()
                    );
                }).toList();
    }
    //private -> public 임시 수정
    public void decreaseProductAmount(List<Product> orderedProducts) {
        orderedProducts
                .stream()
                .forEach(orderedProduct -> {
                    Long productId = orderedProduct.getId();
                    Optional<Product> product = productRepository.findById(productId);

                    Integer orderedAmount = orderedProduct.getAmount();
                    product.get().decreaseAmount(orderedAmount);

                    //엔티티가 데이터베이스에 이미 존재하면 업데이트하고, 존재하지 않으면 새로 삽입
                    productRepository.save(product.get());
                });
    }



}