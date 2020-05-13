package org.example.server;

import org.example.interaction.Request;
import org.example.interaction.Response;
import org.example.interaction.ValidateException;
import org.example.server.product.AccountTypes;
import org.example.server.product.Card;

import java.util.Map;
import java.util.TreeMap;


public class Host {
    private Map<String, Card> cards = new TreeMap<>();

    public Host(Card card) {
        this.cards.put(card.getNumber(), card);
    }

    public Response getBalance(Request request) {
        try {
            validate(request);
        } catch (ValidateException e) {
            e.printStackTrace();
            return new Response(e.getCode(), e.getDesc());
        }

        return new Response(cards.get(request.getNumber()).getAccount(AccountTypes.DEFAULT.ordinal()).getBalance());
    }

    private void validate(Request request) throws ValidateException {
        if (!cards.containsKey(request.getNumber())) {
            throw new ValidateException(3, "Error3");
        }

        Card card = cards.get(request.getNumber());
        if (card.getPIN() != request.getPIN())
            throw new ValidateException(2, "Error2");
        if (!card.getExpDate().equals(request.getExpDate()))
            throw new ValidateException(1, "Error1");
        return;
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
