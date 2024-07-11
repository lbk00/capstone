// com.example.capstone.Item.ItemService.java
package com.example.capstone.Product;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository itemRepository;

    public ProductService(ProductRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    // Business methods for Item
}