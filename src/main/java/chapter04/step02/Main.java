package src.main.java.chapter04.step02;

import src.main.java.chapter04.step02.money.Money;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * 객체들에게 자율성을 부여했지만, 여전히 부족하다.
 * 캡슐화 관점에서 첫 번째 설계보다 향상되었지만 여전히 캡슐화를 위반하고 있다.
 *
 * Movie, DiscountCondition, Screening 등 여전히 캡슐화를 위반하고 있다.
 * 자세한 내용은 해당 클래스에서 확인해보자.
 */

public class Main {

    public static void main(String[] args) {

        List<DiscountCondition> discountConditionList = new ArrayList<>();
        discountConditionList.add(new DiscountCondition(
                DiscountConditionType.SEQUENCE,
                100,
                null,
                null,
                null
        ));

        Movie movie = new Movie(
                "아바타",
                Duration.ofHours(2),
                Money.wons(15000),
                discountConditionList,
                DiscountType.AMOUNT_DISCOUNT,
                Money.wons(6000),
                0
                );
        ReservationAgency reservationAgency = new ReservationAgency();
        Reservation reservation = reservationAgency.reserve(
                new Screening(movie, 100, null),
                new Customer(1L, "케이"),
                2
        );

        System.out.println(reservation.toString());
        System.out.println("지불금액: "+ reservation.getFee());
    }
}
