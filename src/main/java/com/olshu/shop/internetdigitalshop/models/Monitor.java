package com.olshu.shop.internetdigitalshop.models;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("monitor")
public class Monitor extends Product {

    private double diagonal;

    public Monitor() {
    }

    public Monitor(String serialNumber, String manufacturer, double price, int quantity, double diagonal) {
        super(serialNumber, manufacturer, price, quantity);
        this.diagonal = diagonal;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(double diagonal) {
        this.diagonal = diagonal;
    }
}
