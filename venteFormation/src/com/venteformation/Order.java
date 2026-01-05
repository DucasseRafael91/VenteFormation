package com.venteformation;

import java.util.Date;

public class Order {

    private int id;
    private Date date;


    // Constructeur
    public Order(Date date) {
        this.id = id;
        this.date = date;
    }

    // Getters
    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
