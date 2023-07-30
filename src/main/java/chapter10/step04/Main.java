package src.main.java.chapter10.step04;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import src.main.java.chapter10.step04.money.Money;

/**
 * 추상클래스를 통해서 개선해보자
 */
public class Main {
  public static void main(String[] args) {
    Call call =
        new Call(
            LocalDateTime.of(2023, Month.JULY, 23, 23, 0, 0),
            LocalDateTime.of(2023, Month.JULY, 23, 23, 1, 0));

    Phone nightlyDiscountPhone = new NightlyDiscountPhone(Money.wons(5), Money.wons(2), Duration.ofSeconds(10), 0.2);
    Phone regularPhone = new RegularPhone(Money.wons(5), Duration.ofSeconds(10), 0.2);

    nightlyDiscountPhone.call(call);
    regularPhone.call(call);

    Money nightlyDiscountPhoneFee = nightlyDiscountPhone.calculateFee();
    Money regularPhoneFee = regularPhone.calculateFee();

    System.out.println("심야할인이 적용된 통화료는 " + nightlyDiscountPhoneFee.getAmount() + "원 입니다.");
    System.out.println("할인정책이 미적용된 통화료는 " + regularPhoneFee.getAmount() + "원 입니다.");
  }
}
