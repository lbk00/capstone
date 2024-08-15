package com.example.capstone.Order;

import com.example.capstone.Order.testProduct.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //mappedBy 주인 엔터티가 반대쪽인 many
    @OneToMany(mappedBy = "order", cascade = CascadeType.MERGE)
    private List<Product> orderedProducts;


    private Integer totalPrice;
    private OrderType orderType; //< 0 = 주문 전, 1 = 주문 중 , 2 = 납품(주문) 완료 , 3 = 반품 중 , 4 = 반품 완료 , 5 = 취소>


    public Order(List<Product> orderedProducts) {
        this.orderedProducts = orderedProducts;
        this.totalPrice = calculateTotalPrice(orderedProducts);
        this.orderType = OrderType.BEFORE_ORDER;
    }



    private Integer calculateTotalPrice(List<Product> orderedProducts) {
        return orderedProducts
                .stream()
                .mapToInt(orderedProduct -> orderedProduct.getPrice() *orderedProduct.getAmount())
                .sum();
    }

    public Boolean sameId(Long id) {
        return this.id.equals(id);
    }
    public void changeStateForce(OrderType orderType) {
        this.orderType = orderType;
    }

    /* 임시 주석처리
    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private Manager manager;

    @ManyToOne
    @JoinColumn(name = "supplierId", nullable = false)
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "itemId", nullable = false)
    private Product item;

    @Column(nullable = false, length = 20)
    private String quantity;

    @Column(nullable = false, length = 20)
    private String price;

    @Column(nullable = false)
    private int totalPrice;

    @Column(nullable = false, length = 20)
    private String type;

    @Column(nullable = false, length = 20)
    private String to;

    @Column(nullable = false)
    private int tag;
    */

    // getters and setters
}