package src.main.java.chapter02.step01;

import src.main.java.chapter02.step01.money.Money;

import java.math.BigDecimal;

public class Reservation {
    private Customer customer;
    private Screening screening;
    private Money fee;
    private int audienceCount;

    public Reservation(Customer customer, Screening screening, Money fee, int audienceCount) {
        this.customer = customer;
        this.screening = screening;
        this.fee = fee;
        this.audienceCount = audienceCount;
    }

    public BigDecimal getFee() {
        return this.fee.getAmount();
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "customer=" + customer +
                ", screening=" + screening +
                ", fee=" + fee +
                ", audienceCount=" + audienceCount +
                '}';
    }
}
