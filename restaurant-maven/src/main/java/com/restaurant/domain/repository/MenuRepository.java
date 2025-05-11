package com.restaurant.domain.repository;

import java.util.List;
import com.restaurant.domain.model.MenuItem;

public interface MenuRepository {
    void save(MenuItem item);
    MenuItem findById(String id);
    List<MenuItem> findAll();
    void update(MenuItem item);
    void delete(String id);
}
