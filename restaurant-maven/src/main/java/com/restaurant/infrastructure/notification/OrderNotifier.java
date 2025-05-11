package com.restaurant.infrastructure.notification;

import com.restaurant.domain.model.Order;

public class OrderNotifier {
    public void notifyStatus(Order order){
        System.out.println("Notificación: Pedido " + order.getId() + " ahora está " + order.getStatus());
    }
}
