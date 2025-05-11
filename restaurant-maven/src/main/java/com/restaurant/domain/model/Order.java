package com.restaurant.domain.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    public enum Status { RECIBIDO, PREPARACION, LISTO, ENTREGADO }

    private final String id;
    private final Customer customer;
    private final List<MenuItem> items = new ArrayList<>();
    private Status status = Status.RECIBIDO;
    private final LocalDateTime date = LocalDateTime.now();
    private Discount discount;

    public Order(String id, Customer customer){
        this.id = id;
        this.customer = customer;
    }

    // getters
    public String getId(){ return id; }
    public Customer getCustomer(){ return customer; }
    public List<MenuItem> getItems(){ return items; }
    public Status getStatus(){ return status; }
    public LocalDateTime getDate(){ return date; }

    public void addItem(MenuItem item){ items.add(item); }
    public void setDiscount(Discount discount){ this.discount = discount; }

    public double subtotal(){
        return items.stream().mapToDouble(MenuItem::getPrice).sum();
    }

    public double totalAfterDiscount(){
        double amount = subtotal();
        return discount != null ? discount.calculate(amount) : amount;
    }

    public void nextStatus(){
        switch(status){
            case RECIBIDO -> status = Status.PREPARACION;
            case PREPARACION -> status = Status.LISTO;
            case LISTO -> status = Status.ENTREGADO;
            default -> {}
        }
    }

    @Override public String toString(){
        return String.format("Pedido #%s [%s] - Subtotal $%.2f", id, status, subtotal());
    }
}
