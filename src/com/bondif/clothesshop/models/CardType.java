package com.bondif.clothesshop.models;

import java.io.Serializable;

public enum CardType implements Serializable {
    MASTERCARD("Master Card"),
    VISA("Visa"),
    CMI("cmi");

    private String name;

    CardType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
