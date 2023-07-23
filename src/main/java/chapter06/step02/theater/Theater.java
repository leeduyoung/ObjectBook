package src.main.java.chapter06.step02.theater;

/**
 * Theater는 TicketSeller와 Audience의 내부 구조에 관해 묻지말고 원하는 작업을 시켜야 한다.
 *  - Theater가 TicketSeller에게 시키고 싶은 일은 Audience가 Ticket을 가지도록 만드는 것이다.
 *  - TicketSeller가 원하는 것은 Audience가 Ticket을 보유하도록 만드는 것이다.
 *  - Audience가 Bag에게 원하는 일을 시키기전에 hasInvitation 메서드를 이용해 초대권을 가지고 있는지를 묻는데 이를 제거하자.
 *
 *  -> 인터페이스에 의도를 드러내자
 *  현재 인터페이스는 클라이언트의 의도를 명확하게 드러내지 못한다.
 *   - Theater가 TicketSeller에게 setTicket 메시지를 전송해서 얻고 싶었던 것은 audience에게 티켓을 판매하는 것이다.
 *   - TicketSeller가 Audience에게 setTicket 메시지를 전송하는 이유는 Audience가 티켓을 사도록하는 것이다.
 *   - Audience가 Bag에게 setTicket 메시지를 전송하는 이유는 티켓을 보관하도록 하기 위해서다.
 */
public class Theater {
    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    public void enter(Audience audience) {
        this.ticketSeller.setTicket(audience);
    }
}
