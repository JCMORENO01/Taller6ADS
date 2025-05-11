package com.restaurant.infrastructure.persistence;

import com.restaurant.domain.repository.MenuRepository;
import com.restaurant.domain.model.MenuItem;
import java.util.*;

public class InMemoryMenuRepository implements MenuRepository {
    private final Map<String, MenuItem> db = new HashMap<>();

    @Override public void save(MenuItem item){ db.put(item.getId(), item); }
    @Override public MenuItem findById(String id){ return db.get(id); }
    @Override public List<MenuItem> findAll(){ return new ArrayList<>(db.values()); }
    @Override public void update(MenuItem item){ db.put(item.getId(), item); }
    @Override public void delete(String id){ db.remove(id); }
}
