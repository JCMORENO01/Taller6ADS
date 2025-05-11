package com.restaurant.domain.model;

public class MenuItem {
    private String id;
    private String name;
    private double price;
    private String category;
    private String description;

    public MenuItem(String id, String name, double price, String category, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }
    public String getDescription() { return description; }

    public void setName(String name){ this.name = name; }
    public void setPrice(double price){ this.price = price; }
    public void setCategory(String category){ this.category = category; }
    public void setDescription(String description){ this.description = description; }

    @Override
    public String toString() {
        return String.format("%s [%s] - $%.2f", name, category, price);
    }
}
