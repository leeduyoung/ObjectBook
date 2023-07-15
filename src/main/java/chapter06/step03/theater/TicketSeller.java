package src.main.java.chapter06.step03.theater;

public class TicketSeller {
    private TicketOffice ticketOffice;

    public void sellTo(Audience audience) {
        long ticketFee = audience.buy(this.ticketOffice.getTicket());
        this.ticketOffice.plusAmount(ticketFee);
    }
}
