package com.venteformation.Entities;

public class formationType {

    private int id;
    private final String name;


    // Constructeur
    public formationType(String name) {
        this.name = name;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

}
