package com.example.capstone.Order;

import com.example.capstone.Product.Product;
import com.example.capstone.Product.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
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
    @Transactional
    @Override
    public OrderResponseDTO purchase(List<OrderProductRequestDTO> orderProductRequestDtos) {
        //리스트로 받은 상품들의 id를 조회하여 주문서 생성

        List<Product> orderedProducts = makeOrderedProducts(orderProductRequestDtos);
        decreaseProductAmount(orderedProducts);
        //requestDTO를 가지고 order 생성
        // 장바구니이므로 db에 따로 저장 X
        /*
        ordersRepository.save(order);
        */
        // 주문서를 가지고 responseDTO 생성 후 반환
        Order order = new Order(orderedProducts);
        OrderResponseDTO orderResponseDTO = OrderResponseDTO.toDTO(order);
        return orderResponseDTO;
    }

    // 주문서 상태가 주문완료 -> 상품 수량 추가
    @Override
    public OrderResponseDTO createOrder(List<OrderProductRequestDTO> orderProductRequestDtos) {
        // 주문서에 있는 상품 수를 레포지토리에 추가
        List<Product> orderedProducts = makeOrderedProducts(orderProductRequestDtos);
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

                    Integer orderedAmount = orderProductRequestDto.getAmount();
                    product.checkEnoughAmount(orderedAmount);
                    // 재고가 충분한지 확인

                    //조회 후 Product 생성
                    return new Product(
                            product.getName(),
                            product.getPrice(),
                            orderedAmount,
                            product.getOrder(),
                            product.getSize(),
                            product.getItemType(),
                            product.getItemImage()
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
    public void increaseProductAmount(List<Product> orderedProducts) {
        orderedProducts
                .stream()
                .forEach(orderedProduct -> {
                    Long productId = orderedProduct.getId();
                    Product product = productRepository.findById(productId)
                            .orElseThrow(() -> new RuntimeException("Product not found: " + productId));

                    Integer orderedAmount = orderedProduct.getAmount();
                    product.increaseAmount(orderedAmount);

                    //엔티티가 데이터베이스에 이미 존재하면 업데이트하고, 존재하지 않으면 새로 삽입
                    productRepository.save(product);
                });
    }

    @Override
    public OrderResponseDTO complete(Long id) {
        // 주문서 조회
        Optional<Order> order = ordersRepository.findById(id);
        // 주문서에 있는 상품 수량 , 재고에 추가
        increaseProductAmount(order.get().getOrderedProducts());
        // 주문서 상태 -> 주문완료로 변경
        order.get().setOrderType(OrderType.COMPLETE_ORDER);
        ordersRepository.save(order.get());
        OrderResponseDTO orderResponseDTO = OrderResponseDTO.toDTO(order.get());
        return orderResponseDTO;
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

    @Override
    public void deleteOrder(Long id) {
        // 해당 id의 주문서 삭제 , 없는번호면 오류발생
        Order order = ordersRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 주문이 존재하지 않습니다: " + id));
        ordersRepository.deleteById(id);
    }


    @Override
    @Transactional
    public OrderResponseDTO orderUpdate(Long id, OrderUpdateRequestDTO orderUpdateRequestDTO ) {
        //수정할 주문서 조회

        Order order = ordersRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 주문이 존재하지 않습니다: " + id));
        // 주문서 상태가 주문 전일때만 수정가능
        if (order.getOrderType() == OrderType.BEFORE_ORDER) {
            //주문서에서 수정될 id만 찾아서 변경
            // id 리스트 [] , 수량 리스트 []
            // 1. 주문서에 있는 상품리스트에서 id리스트와 일치하는 상품을 찾기
            // 2. 해당 상품리스트의 상품 수량을 변경
            // 3. setOrderProducts 후 저장
            // 새로운 상품id가 추가될수는 없음 , 모든 상품중 일부만 수정될수 있음
            // orderList를 만들고 setOrderedProducts에 넘겨줘야함
            // OrderUpdateRequestDTO에서 상품 id를 하나씩 가져와서 주문서에 있는 orderedProducts를 수정
            List orderList = order.getOrderedProducts();

            //orderList Set 하는 부분 확인
            // 현재는 입력값 , 수량이 적용되지않음
            orderUpdateRequestDTO.getId()
                            .forEach(pId -> {
                                boolean exists = order.getOrderedProducts().stream()
                                        .anyMatch(product -> product.getId().equals(pId));
                                if (exists) { // 주문서에 변경하려는 상품id가 존재한다면
                                System.out.println("pId = " + pId);
                                    int p_index = -1;
                                    for (int i = 0; i < order.getOrderedProducts().size(); i++) {
                                        if (order.getOrderedProducts().get(i).getId().equals(pId)) {
                                            p_index = i;
                                            break;
                                        }
                                    } // 변경하려는 상품의 인덱스
                                    Product product = (Product) orderList.get(p_index); // 상품 객체
                                    Integer pId_int = pId.intValue();
                                    product.setAmount(orderUpdateRequestDTO.getAmount().get(p_index)); // 해당 상품의 수량 변경
                                    orderList.set(p_index,product); // 변경내용 반영

                                }
                            });
            order.setOrderedProducts(orderList);
            // 수정된 객체
            // json 객체만 변경 후 save 할시 DB에 반영안됨
            order.changeOrderedProducts(order.getOrderedProducts());
            order.changeTotalAmount(order.calculateTotalAmount());
            order.changeTotalPrice(order.getTotalPrice());

            ordersRepository.save(order);
            OrderResponseDTO orderResponseDTO = OrderResponseDTO.toDTO(order);
            return orderResponseDTO;
        } else {
            new IllegalArgumentException("주문서 상태가 '주문 전'이 아닙니다.");
            return null;
        }

    }
}