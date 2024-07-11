// com.example.capstone.Orders.OrdersRepository.java
package com.example.capstone.Orders;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
}