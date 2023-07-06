package src.main.java.chapter01.step02;

import java.util.List;

public class TicketOffice {
    private Long amount;
    private List<Ticket> tickets;

    public TicketOffice(Long amount, List<Ticket> tickets) {
        this.amount = amount;
        this.tickets = tickets;
    }

    public void sellTicketTo(Audience audience) {
        Long fee = audience.buy(getTicket());
        plusAmount(fee);
    }

    private Ticket getTicket() {
        return tickets.remove(0);
    }

    public void minusAmount(Long amount) {
        this.amount -= amount;
    }

    public void plusAmount(Long amount) {
        this.amount += amount;
    }


}
