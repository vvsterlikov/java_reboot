package org.example.interaction;

import org.example.server.product.Balance;

import java.util.Optional;

public class Response {
    private Balance balance;
    private int code;
    private String desc;

    public Response(Balance balance) {
        this.balance = balance;
        this.code = 0;
        this.desc = "";

    }

    public Response(int code, String desc) {
        this.balance = null;
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public Optional<Balance> getBalance() {
        return Optional.ofNullable(balance);
    }

    //public ValidateException getValidateException() {
    // return validateException;
    //}
}
