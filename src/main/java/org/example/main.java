package org.example;

import org.example.server.Host;
import org.example.server.product.Account;
import org.example.server.product.Balance;
import org.example.server.product.Card;

import java.time.LocalDate;

public class main {
    public static void main(String[] args) {
        Host host = new Host(
                new Card(
                        new Account(
                                new Balance(1, "USD")
                        ),
                        LocalDate.now(),
                        "123111111",
                        123
                )
        );
        //System.out.println(host);
        System.out.println(host.toString());
    }
}
