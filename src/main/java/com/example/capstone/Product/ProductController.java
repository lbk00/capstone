// com.example.capstone.Item.ItemController.java
package com.example.capstone.Product;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ProductController {

    private final ProductService itemService;

    public ProductController(ProductService itemService) {
        this.itemService = itemService;
    }

    // Endpoints for Item
}