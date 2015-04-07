package com.tsystems.javaschool.DTO;


public class ClientDTO {

    private String name;
    private String surname;
    private String email;
    private Long passport;
    private Long clientsNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPassport() {
        return passport;
    }

    public void setPassport(Long passport) {
        this.passport = passport;
    }

    public Long getClientsNumber() {
        return clientsNumber;
    }

    public void setClientsNumber(Long clientsNumber) {
        this.clientsNumber = clientsNumber;
    }
}
