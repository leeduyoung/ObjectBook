package src.main.java.chapter06.step02.theater;

public class Audience {
    private Bag bag;

    public long SetTicket(Ticket ticket) {
        return this.bag.setTicket(ticket);
    }
}
