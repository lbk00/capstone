package com.example.capstone.Product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByNameAndItemTypeAndSize(String name, String itemType, String size);
    List<Product> findByItemType(String itemType);
}