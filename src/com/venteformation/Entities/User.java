package com.venteformation.Entities;

public class User {

    private int id;
    private String login;
    private String password;


    // Constructeur
    public User(String login, String password) {
        this.id = id;
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

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

