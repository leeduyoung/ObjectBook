package src.main.java.chapter01.step01;

import java.util.ArrayList;
import java.util.List;

/**
 * 무엇이 문제인가?
 *
 * 1. 예상을 빗나가는 코드
 *  - 소극장은 관람객의 가방을 열어 그 안에 초대장이 들어있는지 살펴보고 가방 안에 초대장이 들어있으면
 *    판매원은 매표소에 보관돼 있는 티켓을 관람객의 가방 안으로 옮긴다.
 *    즉, 문제는 관람객과 판매원이 소극장의 통제를 받는 수동적인 존재라는 점이다.
 *
 * 2. 변경에 취약한 코드
 *  - 소극장은 관람객이 가방을 들고 있고 판매원이 판매소에서만 티켓을 판매한다는 지나치게 세부적인
 *    사항에 의존해서 동작한다.
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

