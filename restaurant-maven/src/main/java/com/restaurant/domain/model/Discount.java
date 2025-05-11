package com.restaurant.domain.model;

@FunctionalInterface
public interface Discount {
    double calculate(double amount);
}
