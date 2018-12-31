package com.bondif.clothesshop.models;

import java.io.Serializable;

public class Card implements Serializable {
    private CardType cardType;
    private int num;
    private int expMonth;
    private int expYear;
    private int verificationNum;

    public Card(CardType cardType, int num, int expMonth, int expYear, int verificationNum) {
        this.cardType = cardType;
        this.num = num;
        this.expMonth = expMonth;
        this.expYear = expYear;
        this.verificationNum = verificationNum;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getExpMonth() {
        return expMonth;
    }

    public void setExpMonth(int expMonth) {
        this.expMonth = expMonth;
    }

    public int getExpYear() {
        return expYear;
    }

    public void setExpYear(int expYear) {
        this.expYear = expYear;
    }

    public int getVerificationNum() {
        return verificationNum;
    }

    public void setVerificationNum(int verificationNum) {
        this.verificationNum = verificationNum;
    }
}
