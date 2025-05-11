package com.restaurant.application;

import com.restaurant.domain.repository.OrderRepository;
import com.restaurant.domain.model.*;
import com.restaurant.domain.service.PricingService;
import java.util.*;
import java.util.stream.Collectors;

public class ReportService {
    private final OrderRepository orderRepo;
    private final PricingService pricingService = new PricingService();
    public ReportService(OrderRepository orderRepo){ this.orderRepo = orderRepo; }

    public double dailySales(){
        return orderRepo.findAll().stream()
                .mapToDouble(o -> pricingService.calculateTotal(o))
                .sum();
    }

    public Map<String, Long> popularItems(){
        return orderRepo.findAll().stream()
                .flatMap(o -> o.getItems().stream())
                .collect(Collectors.groupingBy(MenuItem::getName, Collectors.counting()));
    }
}
