package org.example.interaction.payload;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@XmlRootElement(name = "Balance.Payload")
public class BalanceRequestPayload {
    @XmlElement
    private LocalDate expDate;
    @XmlElement
    private String number;
    @XmlElement
    private int PIN;

    public BalanceRequestPayload(LocalDate expDate, String number, int PIN) {
        this.expDate = expDate;
        this.number = number;
        this.PIN = PIN;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getPIN() {
        return PIN;
    }

    public void setPIN(int PIN) {
        this.PIN = PIN;
    }
}
