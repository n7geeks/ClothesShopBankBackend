package com.bondif.models;

import java.io.Serializable;

public class Compte implements Serializable {
    private long id;
    private double montant;
    private Client client;

    public Compte() {
        this.id = 0;
        this.montant = 0.0;
        this.client = null;
    }

    public Compte(long id, double montant, Client client) {
        this.id = id;
        this.montant = montant;
        this.client = client;
    }

    public Compte(double montant, Client client) {
        this.montant = montant;
        this.client = client;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return client.getNom() + " a " + montant + " DH";
    }
}
