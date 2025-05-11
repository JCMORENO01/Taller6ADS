package com.restaurant.domain.model;

public class Customer {
    private final String id;
    private final String name;
    private final String address;
    private final String phone;

    public Customer(String id, String name, String address, String phone){
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getId(){ return id; }
    public String getName(){ return name; }
    public String getAddress(){ return address; }
    public String getPhone(){ return phone; }

    @Override public String toString(){
        return String.format("%s (%s)", name, phone);
    }
}
