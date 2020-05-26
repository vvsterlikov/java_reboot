package org.example.interaction;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@XmlRootElement(name = "Balance_Payload")
public class BalancePayload {
    @XmlElement
    private LocalDate expDate;
    @XmlElement
    private String number;
    @XmlElement
    private int PIN;

    public BalancePayload(LocalDate expDate, String number, int PIN) {
        this.expDate = expDate;
        this.number = number;
        this.PIN = PIN;
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
}
