package com.venteformation;

public class Client {

    private int id;
    private String lastName;
    private String firstName;
    private String mail;
    private String address;
    private String phone_number;
    private User User;


    // Constructeur
    public Client(String lastName, String firstName, String mail, String address, String phone_number, User User) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.mail = mail;
        this.address = address;
        this.phone_number = phone_number;
        this.User = User;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMail() {
        return mail;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phone_number;
    }

    public User getUser() {
        return User;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setUser(User user) {
        this.User = user;
    }
}
