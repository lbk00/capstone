// com.example.capstone.Item.ItemRepository.java
package com.example.capstone.Product;

import com.example.capstone.Order.testProduct.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}