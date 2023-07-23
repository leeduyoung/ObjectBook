package src.main.java.chapter06.step02.theater;

public class TicketSeller {
    private TicketOffice ticketOffice;

    public void setTicket(Audience audience) {
        long ticketFee = audience.SetTicket(this.ticketOffice.getTicket());
        this.ticketOffice.plusAmount(ticketFee);
    }
}
