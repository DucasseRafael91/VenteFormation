package com.venteformation.Entities;

import java.time.LocalDateTime;

public class Order {

    private int id;
    private final LocalDateTime date;
    private final Client client;


    // Constructeur
    public Order(LocalDateTime date, Client client) {
        this.client = client;
        this.date = date;
    }

    // Getters
    public int getId() {
        return id;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }


}
