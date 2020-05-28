package org.example.server.product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Card {
    private List<Account> accounts = new ArrayList<>();
    private LocalDate expDate;
    private String number;
    private int PIN;

    public Card(Account account, LocalDate expDate, String number, int PIN) {
        this.accounts.add(account);
        this.expDate = expDate;
        this.number = number;
        this.PIN = PIN;
    }


    public Optional<Account> getAccount(int indx) {
        if (accounts.size() <= indx) {
            return Optional.empty();
        }
        return Optional.of(accounts.get(indx));

    }


    public LocalDate getExpDate() {
        return expDate;
    }

    public String getNumber() {
        return number;
    }

    public int getPIN() {
        return PIN;
    }

    @Override
    public String toString() {
        String a = new String();
        String result = new String();
        for (int i = 0; i < accounts.size(); i++) {
            a += "account[" + i + "]={" + accounts.get(i).toString() + "};";
        }
        result += "Number=" + number + ";PIN=" + PIN + ";expDate=" + expDate + ";" + a;
        return result;
    }
}
