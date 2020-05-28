package org.example.server;

import org.example.interaction.Request;
import org.example.interaction.Response;
import org.example.interaction.ValidateException;
import org.example.interaction.XMLParser;
import org.example.interaction.payload.BalanceRequestPayload;
import org.example.server.product.AccountTypes;
import org.example.server.product.Balance;
import org.example.server.product.Card;

import javax.xml.bind.JAXBException;
import java.util.Map;
import java.util.TreeMap;

// todo: В классе org.example.server.Host в методах getBalance и validate
//  реализовать логику получения объекта класса BalancePaylod и получения из него необходимых полей с данными запроса.
//  В текущей версии данные запроса получаются на прямую из объекта класса Request.
public class Host {
    private Map<String, Card> cards = new TreeMap<>();

    public Host(Card card) {
        this.cards.put(card.getNumber(), card);
    }

    public Response getBalance(Request rawRequest) throws JAXBException {
        BalanceRequestPayload request = (BalanceRequestPayload) XMLParser.getObject(rawRequest.getPayload(), BalanceRequestPayload.class);
        try {
            validate(request);
        } catch (ValidateException e) {
            e.printStackTrace();
            return new Response(e.getCode(), e.getDesc());
        }
        Balance balance = cards.get(request.getNumber()).getAccount(AccountTypes.DEFAULT.ordinal()).getBalance();
        BalanceResponsePayload paylod = new BalanceResponsePayload(balance.getSum(), balance.getCurrency());
        return new Response(XMLParser.saveObject(paylod));
    }

    private void validate(BalanceRequestPayload request) throws ValidateException {

        if (!cards.containsKey(request.getNumber())) {
            throw new ValidateException(3, "Error3");
        }

        Card card = cards.get(request.getNumber());

        if (card.getPIN() != request.getPIN()) {
            throw new ValidateException(2, "Error2");
        }

        if (!card.getExpDate().equals(request.getExpDate())) {
            throw new ValidateException(1, "Error1");
        }

    }

    @Override
    public String toString() { //лекция 8 задание 1
        String result = "";

        for (Map.Entry<String, Card> entry : cards.entrySet()) {
            String k = entry.getKey();
            Card v = entry.getValue();
            result += "card[" + k + "]={" + v + "};";
        }
        return result;
    }
}
