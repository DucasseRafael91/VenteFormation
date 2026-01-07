package com.venteformation.Entities;

public class Client {

    private int id;
    private final String lastName;
    private final String firstName;
    private final String mail;
    private final String address;
    private final String phoneNumber;
    private final User user;


    // Constructeur
    public Client(Integer id, String lastName, String firstName, String mail, String address, String phoneNumber, User user) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.mail = mail;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.user = user;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + " | Email: " + mail + " | Téléphone: " + phoneNumber + " | Adresse: " + address;
    }


    // Getters
    public int getId() {
        return id;
    }


    // Setters
    public void setId(int id) {
        this.id = id;
    }

}
