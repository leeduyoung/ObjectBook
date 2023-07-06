package src.main.java.chapter01.step01;

import java.util.List;

public class TicketOffice {
    private Long amount;
    private List<Ticket> tickets;

    public TicketOffice(Long amount, List<Ticket> tickets) {
        this.amount = amount;
        this.tickets = tickets;
    }

    public Ticket getTicket() {
        return tickets.remove(0);
    }

    public void minusAmount(Long amount) {
        this.amount -= amount;
    }

    public void plusAmount(Long amount) {
        this.amount += amount;
    }
}
