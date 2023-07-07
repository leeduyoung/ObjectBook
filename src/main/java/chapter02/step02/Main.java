package src.main.java.chapter02.step02;

import src.main.java.chapter02.step02.money.Money;
import src.main.java.chapter02.step02.pricing.AmountDiscountPolicy;
import src.main.java.chapter02.step02.pricing.NoneDiscountPolicy;
import src.main.java.chapter02.step02.pricing.PeriodDiscountCondition;
import src.main.java.chapter02.step02.pricing.SequenceDiscountCondition;

import java.time.*;

public class Main {
    public static void main(String[] args) {
        Movie movie = new Movie(
                "아바타",
                Duration.ofHours(2),
                Money.wons(15000),
                new AmountDiscountPolicy(
                        Money.wons(6000),
                        new SequenceDiscountCondition(1),
                        new SequenceDiscountCondition(100),
                        new PeriodDiscountCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                        new PeriodDiscountCondition(DayOfWeek.WEDNESDAY, LocalTime.of(10, 0), LocalTime.of(11, 59))
                )
        );

        Screening screening = new Screening(movie, 100, LocalDateTime.of(2023, Month.AUGUST, 23, 12, 00));
        Reservation reservation = screening.reserve(new Customer("케이"), 2);
        System.out.println(reservation.toString());
        System.out.println("지불금액: "+ reservation.getFee());

        System.out.println();

        Movie movie2 = new Movie(
                "엘리멘탈",
                Duration.ofHours(2),
                Money.wons(15000),
                new NoneDiscountPolicy()
        );

        Screening screening2 = new Screening(movie2, 100, LocalDateTime.of(2023, Month.AUGUST, 23, 12, 00));
        Reservation reservation2 = screening2.reserve(new Customer("시현"), 2);
        System.out.println(reservation2.toString());
        System.out.println("지불금액: "+ reservation2.getFee());
    }
}
