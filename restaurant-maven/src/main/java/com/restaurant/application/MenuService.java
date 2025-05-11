package com.restaurant.application;

import com.restaurant.domain.repository.MenuRepository;
import com.restaurant.domain.model.MenuItem;
import java.util.List;

public class MenuService {
    private final MenuRepository repo;
    public MenuService(MenuRepository repo){ this.repo = repo; }

    public void addMenuItem(MenuItem item){ repo.save(item); }
    public List<MenuItem> list(){ return repo.findAll(); }
    public MenuItem find(String id){ return repo.findById(id); }

    public void updateMenuItem(MenuItem item){ repo.update(item); }
    public void removeMenuItem(String id){ repo.delete(id); }
}
