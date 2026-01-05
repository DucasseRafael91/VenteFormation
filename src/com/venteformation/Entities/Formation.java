package com.venteformation.Entities;

public class Formation {

    private int id;
    private String name;
    private String description;
    private Integer days_amount;
    private Double price;
    private Category category;


    // Constructeur
    public Formation(String name, String description, Integer days_amount, Double price, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.days_amount = days_amount;
        this.price = price;
        this.category = category;

    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getDaysAmount() {
        return days_amount;
    }

    public Double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDaysAmount(Integer days_amount) {
        this.days_amount = days_amount;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
