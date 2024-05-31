package com.braden.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String name;

    private String email;

    private float bankBalance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getBankBalance() {
        return bankBalance;
    }

    public void setBankBalance(float bankBalance) {
        this.bankBalance = bankBalance;
    }

    public void increaseBankBalance(float amount) {
        this.bankBalance += amount;
    }

    public void decreaseBankBalance(float amount) {
        this.bankBalance -= amount;
    }
}