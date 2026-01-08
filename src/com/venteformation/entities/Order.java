package com.venteformation.entities;

import java.time.LocalDateTime;

public class Order {

  private final LocalDateTime date;
  private final Client client;
  private int id;

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
