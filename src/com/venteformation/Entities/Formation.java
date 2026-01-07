package com.venteformation.Entities;

public class Formation {

    private int id;
    private final String name;
    private final String description;
    private final Integer daysAmount;
    private final Double price;
    private final Category category;


    // Constructeur
    public Formation(String name, String description, Integer daysAmount, Double price, Category category) {
        this.name = name;
        this.description = description;
        this.daysAmount = daysAmount;
        this.price = price;
        this.category = category;

    }

    @Override
    public String toString() {
        return
                "Nom: " + name + "description: " + description +
                " | Durée: " + daysAmount + " jours" +
                " | Prix: " + price + " €" +
                " | Catégorie: " + category;
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
