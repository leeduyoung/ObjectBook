package src.main.java.chapter06.step03.theater;

public class Audience {
    private Bag bag;

    public long buy(Ticket ticket) {
        return this.bag.hold(ticket);
    }
}
