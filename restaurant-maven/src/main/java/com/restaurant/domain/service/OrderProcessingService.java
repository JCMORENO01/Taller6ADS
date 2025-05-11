package com.restaurant.domain.service;

import com.restaurant.domain.model.Order;
import com.restaurant.infrastructure.notification.OrderNotifier;

public class OrderProcessingService {
    private final OrderNotifier notifier;
    public OrderProcessingService(OrderNotifier notifier){ this.notifier = notifier; }

    public void advance(Order order){
        order.nextStatus();
        notifier.notifyStatus(order);
    }
}
