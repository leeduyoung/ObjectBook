package src.main.java.chapter10.step02;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import src.main.java.chapter10.step02.money.Money;

public class Main {

  public static void main(String[] args) {
    Call call =
        new Call(
            LocalDateTime.of(2023, Month.JULY, 23, 23, 0, 0),
            LocalDateTime.of(2023, Month.JULY, 23, 23, 1, 0));
    NightlyDiscountPhone phone = new NightlyDiscountPhone(Money.wons(5), Money.wons(2), Duration.ofSeconds(10));
    phone.call(call);

    Money fee = phone.calculateFee();
    System.out.println("통화료는 " +fee.getAmount() + "원 입니다.");
  }
}
