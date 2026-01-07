package com.venteformation.Entities;

public class User {

    private int id;
    private final String login;
    private final String password;


    // Constructeur
    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

}

