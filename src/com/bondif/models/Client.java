package com.bondif.models;

import java.io.Serializable;

public class Client implements Serializable {
    private long id;
    private String nom;
    private Compte compte;

    public Client() {
        this.id = 0;
        this.nom = "";
        this.compte = null;
    }

    public Client(long id, String nom, Compte compte) {
        this.id = id;
        this.nom = nom;
        this.compte = compte;
        this.compte.setClient(this);
    }

    public Client(String nom, Compte compte) {
        this.nom = nom;
        this.compte = compte;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }
}
