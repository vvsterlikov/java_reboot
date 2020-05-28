package org.example.interaction;

//import org.example.server.product.Balance;

import java.util.Optional;

public class Response {
    //private Balance balance;
    private String payload;
    private int code;
    private String desc;

    public Response(String payload) {
        this.payload = payload;
        this.code = 0;
        this.desc = "";

    }

    public Response(int code, String desc) {
        this.payload = null;
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public Optional<String> getBalance() {
        return Optional.ofNullable(payload);
    }

    //public ValidateException getValidateException() {
    // return validateException;
    //}
}
