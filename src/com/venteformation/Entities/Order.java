package com.venteformation.Entities;

import java.time.LocalDateTime;
import java.util.Date;

public class Order {

    private int id;
    private LocalDateTime date;
    private Client client;


    // Constructeur
    public Order(LocalDateTime date, Client client) {
        this.client = client;
        this.id = id;
        this.date = date;
    }

    // Getters
    public int getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}
