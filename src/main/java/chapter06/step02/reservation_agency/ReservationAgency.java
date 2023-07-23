package src.main.java.chapter06.step02.reservation_agency;

import src.main.java.chapter06.step02.money.Money;

/**
 * 아래 코드에서는 ReeservationAgency는
 * Screening 내부에 대한 어떤 정보도 알지 못한다.
 *
 * 디미터 법칙을 따르는 코드는 메시지 수신자의 내부 구조가 전송자에게 노출되지 않으며 메시지 전송자는
 * 수신자의 내부 구현에 결합되지 않는다.
 */

public class ReservationAgency {
    public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
        Money fee = screening.calculateFee(audienceCount);
        return new Reservation(customer, screening, fee, audienceCount);
    }
}
