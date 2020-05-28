package org.example.interaction.payload;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Balance.Payload")
public class BalanceResponsePayload {
    @XmlElement
    private int sum;
    @XmlElement
    private String currency;

    public BalanceResponsePayload(int sum, String currency) {
        this.sum = sum;
        this.currency = currency;
    }

    public int getSum() {
        return sum;
    }

    public String getCurrency() {
        return currency;
    }
}
