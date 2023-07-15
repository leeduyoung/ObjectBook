package src.main.java.chapter06.step01.theater;

/**
 * 디미터 법칙을 위반하는 티켓 판매 도메인
 *
 * Audience가 Bag을 포함하고 있다는 사실을 Audience의 내부 구현에
 * 속하며 Audience는 자신의 내부 구현을 자유롭게 변경할 수 있어야 한다.
 * Theater는 TicketSeller가 getTicketOffice 메시지를 수신할 수 있다는 사실 뿐만 아니라
 * 내부에 TicketOffice를 포함하고 있다는 사실도 알고 있어야 한다. 또한 TicketOffice가
 * getTicket 메시지를 수신할 수 있으며 이 메서드가 반환하는 Ticket 인스턴스가 getFee 메시지를 이해할 수 있다는
 * 사실도 알아야 한다.
 *
 * Theater는 TicketSeller와 Audience의 내부 구조에 관해 묻지말고 원하는 작업을 시켜야 한다.
 *  - Theater가 TicketSeller에게 시키고 싶은 일은 Audience가 Ticket을 가지도록 만드는 것이다.
 *  - TicketSeller가 원하는 것은 Audience가 Ticket을 보유하도록 만드는 것이다.
 *  - Audience가 Bag에게 원하는 일을 시키기전에 hasInvitation 메서드를 이용해 초대권을 가지고 있는지를 묻는데 이를 제거하자.
 */
public class Theater {
    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    public void enter(Audience audience) {
        if (audience.getBag().hasInvitation()) {
            Ticket ticket = this.ticketSeller.getTicketOffice().getTicket();
            audience.getBag().setTicket(ticket);
        } else {
            Ticket ticket = this.ticketSeller.getTicketOffice().getTicket();
            audience.getBag().minusAmount(ticket.getFee());
            ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
            audience.getBag().setTicket(ticket);
        }
    }
}
