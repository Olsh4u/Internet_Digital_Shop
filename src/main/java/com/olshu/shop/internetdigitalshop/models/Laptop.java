package com.olshu.shop.internetdigitalshop.models;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("laptop")
public class Laptop extends Product {

    private int screenSize;

    public Laptop() {
        // Пустой конструктор для Hibernate
    }

    public Laptop(String serialNumber, String manufacturer, double price, int quantity, int screenSize) {
        super(serialNumber, manufacturer, price, quantity);
        this.screenSize = screenSize;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }
}
