package com.restaurant;

import com.restaurant.domain.model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderStateTest {

    @Test
    void stateTransitions() {
        Customer c = new Customer("C","Test","Dir","300");
        Order o = new Order("1", c);

        assertEquals(Order.Status.RECIBIDO, o.getStatus());
        o.nextStatus();
        assertEquals(Order.Status.PREPARACION, o.getStatus());
        o.nextStatus();
        assertEquals(Order.Status.LISTO, o.getStatus());
        o.nextStatus();
        assertEquals(Order.Status.ENTREGADO, o.getStatus());
    }
}
