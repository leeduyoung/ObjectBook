package src.main.java.chapter06.step02.theater;

public class Bag {
    private Ticket ticket;
    private long amount;

    public boolean hasInvitation() {
        return this.ticket != null;
    }

    public long setTicket(Ticket ticket) {
        if (this.hasInvitation()) {
            this.ticket = ticket;
            return 0;
        } else {
            this.minusAmount(ticket.getFee());
            this.ticket = ticket;
            return ticket.getFee();
        }
    }

    public void minusAmount(long fee) {
        this.amount = this.amount - fee;
    }
}
