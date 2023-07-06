package src.main.java.chapter01.step02;

import java.util.ArrayList;
import java.util.List;

/**
 * 무엇이 개선됐는가
 *  - 관람객과 판매원은 자신이 가지고 있는 소지품을 스스로 관리하게 됐다.
 *  - 또한, 변경에 유연해졌다. 관람객과 판매원의 로직이 변경되더라도 소극장의 코드는 변경할 필요가 없다.
 *
 * 어떻게 한것인가?
 *  - 객체의 자율성을 높이는 방향으로 설계를 개선했다.
 */

public class Main {
    public static void main(String[] args) {
        List<Ticket> tickets = new ArrayList<>();
        for (int i = 0; i <5; i++) {
            tickets.add(new Ticket(9000L));
        }
        TicketOffice ticketOffice = new TicketOffice(0L, tickets);
        TicketSeller ticketSeller = new TicketSeller(ticketOffice);
        Theater theater = new Theater(ticketSeller);

        /**
         * Case1. 초대장이 있는 관람객
         */
        Audience audience01 = new Audience(new Bag(new Invitation(), 10000L ));
        theater.enter(audience01);

        /**
         * Case2. 초대장이 없는 관람객
         */
        Audience audience02 = new Audience(new Bag(null, 20000L));
        theater.enter(audience02);
    }
}

