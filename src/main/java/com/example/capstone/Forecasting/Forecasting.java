package com.example.capstone.Forecasting;


import com.example.capstone.Product.Product;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Forecasting")
public class Forecasting {

    @Id
    @ManyToOne
    @JoinColumn(name = "itemId", nullable = false)
    private Product product;

    private String size;

    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(nullable = false)
    private int itemQuantity;

    @Column(nullable = false, length = 20)
    private String itemType;

    // getters and setters
}