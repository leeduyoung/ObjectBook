package src.main.java.chapter04.step01;

import src.main.java.chapter04.step01.money.Money;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

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
