package src.main.java.chapter06.step01.theater;

import src.main.java.chapter06.step02.money.Money;

public class Bag {
    private boolean invitation;
    private Ticket ticket;
    private long amount;

    public boolean hasInvitation() {
        return this.invitation;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void minusAmount(long fee) {
        this.amount = this.amount - fee;
    }
}
