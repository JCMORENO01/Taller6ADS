package com.restaurant.domain.model;

public class FixedDiscount implements Discount {
    private final double discount;
    public FixedDiscount(double discount){ this.discount = discount; }
    @Override public double calculate(double amount){
        return Math.max(0, amount - discount);
    }
    @Override public String toString(){
        return String.format("Descuento fijo $%.2f", discount);
    }
}
