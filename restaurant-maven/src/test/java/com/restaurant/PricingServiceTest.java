package com.restaurant;

import com.restaurant.domain.model.*;
import com.restaurant.domain.service.PricingService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PricingServiceTest {

    @Test
    void totalIncludesTaxAndDiscount() {
        Order order = new Order("1", new Customer("C","X","Dir","300"));
        order.addItem(new MenuItem("M","Burger",10000,"Main",""));
        order.setDiscount(new PercentDiscount(10)); // 10 %

        double total = new PricingService().calculateTotal(order);
        assertEquals(10710, total, 0.1);
    }
}
