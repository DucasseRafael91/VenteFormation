package com.venteformation.entities;

public class FormationType {

  private final String name;
  private int id;

  // Constructeur
  public FormationType(String name) {
    this.name = name;
  }

  // Getters
  public int getId() {
    return id;
  }

  // Setters
  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

}
