package com.braden.entity;

import jakarta.persistence.*;

@Entity
@Table(name="transactions")
public class Transactions {

    private int recipientId;

    private int senderId;

    private float amount;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int transactionId;

    public Transactions() {

    }

    public void createTransaction(int senderId, int recipientId, float amount) {
        this.recipientId = recipientId;
        this.senderId = senderId;
        this.amount = amount;
    }

    public int getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(int recipientId) {
        this.recipientId = recipientId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getTransactionId() {
        return transactionId;
    }
}
