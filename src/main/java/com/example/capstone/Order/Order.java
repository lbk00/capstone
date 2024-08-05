package com.example.capstone.Order;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Order {


    public Order(OrderRequestDTO orderRequestDTO) {
        this.totalPrice = 10000;
        this.state = "CREATED";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer totalPrice;
    private String state;

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