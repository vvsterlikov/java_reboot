package org.example.client;

import org.example.interaction.Request;
import org.example.interaction.XMLParser;
import org.example.interaction.payload.BalanceRequestPayload;

import javax.xml.bind.JAXBException;
import java.time.LocalDate;

//todo: В классе org.example.clien.ATM в методе getBalance как наилучшим образом обрабатывать ошибки (exeption)
// парсинга классов. Нужно клиентскому коду каким либо образом сообщать об ошибке компиляции.
// Клиентский код в данном случаи в классе org.example.Main

//todo: (сделано) В классе org.example.clien.ATM добавить поля типа интерфейса из пункта 3 (на сайте КУ описано в такой последовательности.
// Задача с общим интерфейсом для классов парсеров). Инициализировать это поле в конструкторе класса ATM и
// добавить сеттер для изменения этого поля. Оно будет меняться на уровне класса org.example.Main
public class ATM {
    Host host;

    private String msgFormat;

    public ATM(Host host, MessageFormat msgFormat) {
        this.host = host;
        this.msgFormat = msgFormat.toString();
    }

    public Balance getBalance(LocalDate expDate, String number, int PIN) {

//        Request request = new Request(expDate, number, PIN);
//        Responce responce = host.getBalance(request);
//        Optional<Balance> balance = responce.getBalance();
//        return  balance.orElse();

        BalanceRequestPayload paylod = new BalanceRequestPayload(expDate, number, PIN);

        Request request = null;
        try {
            request = new Request(XMLParser.saveObject(paylod));
        } catch (JAXBException e) {
            e.printStackTrace();
            System.exit(1);
        }

        return host.getBalance(request).
                getBalance().orElse(new Balance(0, "USD"));
    }

    public void setMsgFormat(MessageFormat msgFormat) {
        this.msgFormat = msgFormat.toString();
    }
}
