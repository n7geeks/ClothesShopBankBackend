package com.bondif.clothesshop.models;

import java.io.Serializable;

public class Account implements Serializable {
    private int id;
    private Card card;
    private Customer customer;
    private double amount;

    public Account(int id, Card card, Customer customer, double amount) {
        this.id = id;
        this.card = card;
        this.customer = customer;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
