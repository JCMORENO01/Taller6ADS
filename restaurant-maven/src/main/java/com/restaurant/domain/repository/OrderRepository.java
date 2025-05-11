package com.restaurant.domain.repository;

import java.util.List;
import com.restaurant.domain.model.Order;

public interface OrderRepository {
    void save(Order order);
    Order findById(String id);
    List<Order> findAll();
}
