// com.example.capstone.Item.Item.java
package com.example.capstone.Product;

import com.example.capstone.Manager.Manager;
import jakarta.persistence.*;


//@Entity
//@Table(name = "Product")
public class ProductA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private Manager manager;

    @Column(nullable = false, length = 20)
    private String itemName;

    private String size;

    private String itemType;

    @Lob
    private byte[] itemImage;

    @Column(nullable = false)
    private int quantity;


    public void setId(Long id) {
        this.itemId = id;
    }

    // getters and setters
}