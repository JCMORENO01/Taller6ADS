package com.restaurant.application;

import com.restaurant.domain.repository.*;
import com.restaurant.domain.model.*;
import com.restaurant.domain.service.*;
import com.restaurant.infrastructure.notification.OrderNotifier;
import java.util.UUID;

public class OrderService {
    private final OrderRepository orderRepo;
    private final MenuRepository menuRepo;
    private final OrderProcessingService processingService;
    private final PricingService pricingService;

    public OrderService(OrderRepository orderRepo, MenuRepository menuRepo, OrderNotifier notifier){
        this.orderRepo = orderRepo;
        this.menuRepo = menuRepo;
        this.processingService = new OrderProcessingService(notifier);
        this.pricingService = new PricingService();
    }

    public Order createOrder(Customer customer){
        Order o = new Order(UUID.randomUUID().toString().substring(0,8), customer);
        orderRepo.save(o);
        return o;
    }

    public void addItem(String orderId, String menuItemId){
        Order o = orderRepo.findById(orderId);
        MenuItem item = menuRepo.findById(menuItemId);
        if(o != null && item != null){ o.addItem(item); }
    }

    public void applyDiscount(String orderId, Discount discount){
        Order o = orderRepo.findById(orderId);
        if(o != null){ o.setDiscount(discount); }
    }

    public void advanceStatus(String orderId){
        Order o = orderRepo.findById(orderId);
        if(o != null){ processingService.advance(o); }
    }

    public double total(String orderId){
        Order o = orderRepo.findById(orderId);
        return o == null ? 0 : pricingService.calculateTotal(o);
    }

    public Order get(String id){ return orderRepo.findById(id); }
}
