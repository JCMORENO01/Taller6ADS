package com.restaurant.domain.service;

import com.restaurant.domain.model.Order;

public class PricingService {
    public static final double TAX_RATE = 0.19; // 19 %

    public double calculateTotal(Order order){
        double afterDiscount = order.totalAfterDiscount();
        return afterDiscount * (1 + TAX_RATE);
    }
}
