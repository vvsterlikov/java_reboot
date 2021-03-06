package org.example;

import org.example.interaction.Request;
import org.example.server.Host;
import org.example.server.product.Account;
import org.example.server.product.Balance;
import org.example.server.product.Card;

import java.time.LocalDate;

public class main {
    public static void main(String[] args) {
        LocalDate d = LocalDate.now();
        Host host = new Host(
                new Card(
                        new Account(
                                new Balance(999, "USD")
                        ),
                        d,
                        "123111111",
                        123
                )
        );
        //System.out.println(host);
        System.out.println(host.toString());
        System.out.println("sum = " + host.getBalance(new Request(d, "123111111", 123)).getBalance().orElse(new Balance()).getSum());
    }
}
