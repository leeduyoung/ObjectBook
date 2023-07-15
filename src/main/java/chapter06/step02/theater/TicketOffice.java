package src.main.java.chapter06.step02.theater;

import java.util.List;

public class TicketOffice {
    private List<Ticket> ticketList;
    private long amount;

    public Ticket getTicket() {
        return this.ticketList.remove(0);
    }

    public void plusAmount(long fee) {
        this.amount += fee;
    }
}
