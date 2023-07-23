package src.main.java.chapter06.step03.theater;

/**
 *  인터페이스에 의도를 드러내자
 *  현재 인터페이스는 클라이언트의 의도를 명확하게 드러내지 못한다.
 *   - Theater가 TicketSeller에게 setTicket 메시지를 전송해서 얻고 싶었던 것은 audience에게 티켓을 판매하는 것이다. (setTicket -> sellTo)
 *   - TicketSeller가 Audience에게 setTicket 메시지를 전송하는 이유는 Audience가 티켓을 사도록하는 것이다. (setTicket -> buy)
 *   - Audience가 Bag에게 setTicket 메시지를 전송하는 이유는 티켓을 보관하도록 하기 위해서다. (setTicket -> hold)
 */
public class Theater {
    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    public void enter(Audience audience) {
        this.ticketSeller.sellTo(audience);
    }
}
