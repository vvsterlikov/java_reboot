package org.example.server.product;

import org.example.interaction.AccountNotFoundException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    /*
        public Optional<Account> getAccount(int indx) {
            Optional<Account> account = Optional.empty();
            try {
                account = Optional.ofNullable(accounts.get(indx));
            }
            catch (IndexOutOfBoundsException outOfBoundException) {
                //log.error("12);
            } finally {

            }
            return account;
        }

     */
  /*  public Account getAccount(int indx) {
        Account account = new Account(new Balance(1,"USD"));
        try {
            account = accounts.get(indx);
        }
        catch (IndexOutOfBoundsException outOfBoundException) {
            //log.error("12);
        } finally {

        }
        return account;
    }
*/
    public Account getAccount(int indx) {
        if (accounts.size() <= indx) {
            throw new AccountNotFoundException();
            //подумать except или optional и запушить в две разные ветки
        }
        //Optional.empty().orElseThrow(()-> new RuntimeException());
        return accounts.get(indx);

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
