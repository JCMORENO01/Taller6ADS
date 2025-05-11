package com.restaurant;

import com.restaurant.application.MenuService;
import com.restaurant.domain.model.MenuItem;
import com.restaurant.infrastructure.persistence.InMemoryMenuRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MenuServiceTest {

    @Test
    void crudOperations() {
        var repo = new InMemoryMenuRepository();
        var service = new MenuService(repo);

        MenuItem item = new MenuItem("P1","Pizza",12000,"Main","4 quesos");
        service.addMenuItem(item);
        assertEquals(1, service.list().size());

        // modify
        item.setPrice(13000);
        service.updateMenuItem(item);
        assertEquals(13000, service.find("P1").getPrice());

        // delete
        service.removeMenuItem("P1");
        assertTrue(service.list().isEmpty());
    }
}
