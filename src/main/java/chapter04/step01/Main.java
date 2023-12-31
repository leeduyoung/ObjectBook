package src.main.java.chapter04.step01;

import src.main.java.chapter04.step01.money.Money;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * 데이터 중심의 영화 예매 시스템
 *
 * 높은 결합도 문제
 * ReservationAgency는 예매 요금을 계산하기 위해서 Movie의 getFee 메서드를 호출하며
 * 계산된 결과를 Money 타입의 fee에 저장한다. 이때 Movie의 fee의 타입을 변경한다고 가정해보자.
 * 이를 위해서는 Movie와 함께 ReservationAgency도 수정이 필요하다!
 * (클래스 변수를 private으로 선언했다고 해도 접근자와 수정자를 통해 속성을 외부로 제공하고 있다면 캡슐화를 위반하는 것이다.)
 *
 * 또한, DiscountCondition의 데이터가 변경되면 ReservationAgency도 함께 수정해야한다.
 * Screening도 마찬가지다.
 *
 * 캡슐화가 제대로 일어나지 않은 문제로 몸살을 앓고 있다!
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
