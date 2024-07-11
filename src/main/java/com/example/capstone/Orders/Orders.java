package com.example.capstone.Orders;

import com.example.capstone.Product.Product;
import com.example.capstone.Manager.Manager;
import com.example.capstone.Supplier.Supplier;

import javax.persistence.*;

@Entity
@Table(name = "Orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sn;

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

    // getters and setters
}