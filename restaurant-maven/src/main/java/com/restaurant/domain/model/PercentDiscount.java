package com.restaurant.domain.model;

public class PercentDiscount implements Discount {
    private final double percent;
    public PercentDiscount(double percent){ this.percent = percent; }
    @Override public double calculate(double amount){
        return amount * (1 - percent/100.0);
    }
    @Override public String toString(){
        return String.format("Descuento %.0f%%", percent);
    }
}
