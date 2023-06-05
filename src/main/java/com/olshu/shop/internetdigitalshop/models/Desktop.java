package com.olshu.shop.internetdigitalshop.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;


@Entity
@DiscriminatorValue("desktop")
public class Desktop extends Product {

    private String formFactor;


    public Desktop() {
    }

    public Desktop(String serialNumber, String manufacturer, double price, int quantity, String formFactor) {
        super(serialNumber, manufacturer, price, quantity);
        this.formFactor = formFactor;
    }

    public String getFormFactor() {
        return formFactor;
    }

    public void setFormFactor(String formFactor) {
        this.formFactor = formFactor;
    }
}
