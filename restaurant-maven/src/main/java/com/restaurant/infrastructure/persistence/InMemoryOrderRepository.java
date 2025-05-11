package com.restaurant.infrastructure.persistence;

import com.restaurant.domain.repository.OrderRepository;
import com.restaurant.domain.model.Order;
import java.util.*;

public class InMemoryOrderRepository implements OrderRepository {
    private final Map<String, Order> db = new HashMap<>();
    @Override public void save(Order o){ db.put(o.getId(), o); }
    @Override public Order findById(String id){ return db.get(id); }
    @Override public List<Order> findAll(){ return new ArrayList<>(db.values()); }
}
