package com.bondif.clothesshop.core;

import com.bondif.clothesshop.models.Account;
import com.bondif.clothesshop.models.Card;
import com.bondif.clothesshop.models.CardType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDao {
    public Account find(Account account) {
        Account acc = null;
        String sql = "select * from accounts a, cards c where a.card_id = c.id and " +
                "c.type = ? and c.num = ? and c.exp_month = ? and c.exp_year = ? and c.verification_code = ?";
        PreparedStatement pstmt;
        ResultSet rs;

        try {
            pstmt = Database.getInstance().getConnection().prepareStatement(sql);
            pstmt.setString(1, cardTypeToInt(account.getCard().getCardType()) + "");
            pstmt.setInt(2, account.getCard().getNum());
            pstmt.setInt(3, account.getCard().getExpMonth());
            pstmt.setInt(4, account.getCard().getExpYear());
            pstmt.setInt(5, account.getCard().getVerificationNum());
            rs = pstmt.executeQuery();

            while (rs.next()) {
                double amount = rs.getInt("a.amount");
                int id = rs.getInt("a.id");
                int type = rs.getInt("c.type");
                int num = rs.getInt("c.num");
                int expMonth = rs.getInt("c.exp_month");
                int expYear = rs.getInt("c.exp_year");
                int verificationCode = rs.getInt("c.verification_code");
                Card card = new Card(intToCardType(type), num, expMonth, expYear, verificationCode);

                acc = new Account(id, card, null, amount);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return acc;
    }

    public void withdrawal(Account account, double drawal) {
        PreparedStatement pstsmt;

        String query = "update accounts set amount = ? where id = ?";
        try {
            pstsmt = Database.getInstance().getConnection().prepareStatement(query);
            pstsmt.setDouble(1, account.getAmount() - drawal);
            pstsmt.setInt(2, account.getId());
            System.out.println(drawal + " " + account.getAmount());

            pstsmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private CardType intToCardType(int type) {
        switch (type) {
            case 0:
                return CardType.MASTERCARD;
            case 1:
                return CardType.VISA;
            case 2:
                return CardType.CMI;
        }
        return CardType.MASTERCARD;
    }

    private int cardTypeToInt(CardType cardType) {
        switch (cardType) {
            case MASTERCARD:
                return 0;
            case VISA:
                return 1;
            case CMI:
                return 2;
        }
        return 0;
    }
}
