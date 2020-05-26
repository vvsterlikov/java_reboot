package org.example.client;

import org.example.interaction.BalancePayload;
import org.example.interaction.Request;
import org.example.interaction.XMLParser;
import org.example.server.Host;
import org.example.server.product.Balance;

import javax.xml.bind.JAXBException;
import java.time.LocalDate;

public class ATM {
    Host host;

    public ATM(Host host) {
        this.host = host;
    }

    public Balance getBalance(LocalDate expDate, String number, int PIN) {
        //JaxbParser.saveObject();
        //JaxbParser.getObject();
        BalancePayload payload = new BalancePayload(expDate, number, PIN);
        Request request = null;
        try {
            request = new Request(XMLParser.saveObject(payload));
        } catch (JAXBException e) {
            e.printStackTrace();
            System.exit(1);
            //todo: как "красиво" обработать ошибку и представить кленту (банкомату)
        }

        return host.getBalance(request).getBalance().orElse(new Balance(0, "USD"));
    }
}
