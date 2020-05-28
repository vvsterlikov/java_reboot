package org.example.interaction;

public class Request {
    //todo: выделить 3 поля в отдельный класс и создать поле payload типа этого классса.
    //переписать код для использования этого класса
    //сделать аннотации
    //потом передавать с банкомата на хост строку xml
    private String payload;

    public Request(String payload) {
        this.payload = payload;
    }

    public String getPayload() {
        return payload;
    }
}
