// com.example.capstone.Orders.OrdersRepository.java
package com.example.capstone.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}