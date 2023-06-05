package com.olshu.shop.internetdigitalshop.models;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("hard_drive")
public class HardDrive extends Product {

    private int capacity;

    public HardDrive() {
    }

    public HardDrive(String serialNumber, String manufacturer, double price, int quantity, int capacity) {
        super(serialNumber, manufacturer, price, quantity);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
