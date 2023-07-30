package src.main.java.chapter10.step03;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import src.main.java.chapter10.step03.money.Money;

/**
 * Phone을 복사해서 만든 NightlyDiscountPhone은 구현하는데 짧은 시간이 걸렸지만 Phone과의 중복 코드가 존재한다. 이 문제는 점차 커지게 되고 언제
 * 터질지 모르는 시한폭탄이 될 수 있다!
 *
 * 이 코드가 수정에 미치는 영향을 보기 위해서 통화 요금에 부과할 세금을 추가하는 기능을 더 해보자
 * 통화 요금을 계산하는 로직은 Phone과 NightlyDiscountPhone에 구현되어 있기 때문에
 * 두 클래스를 모두 수정해줘야한다.
 */
public class Main {
  public static void main(String[] args) {
    Call call =
        new Call(
            LocalDateTime.of(2023, Month.JULY, 23, 23, 0, 0),
            LocalDateTime.of(2023, Month.JULY, 23, 23, 1, 0));
    NightlyDiscountPhone phone =
        new NightlyDiscountPhone(Money.wons(5), Money.wons(2), Duration.ofSeconds(10), 0.2);
    phone.call(call);

    Money fee = phone.calculateFee();
    System.out.println("심야할인이 적용된 통화료는 " + fee.getAmount() + "원 입니다.");

    System.out.println();
    System.out.println();

    Phone phone2 = new Phone(Money.wons(5), Duration.ofSeconds(10), 0.2);
    phone2.call(call);

    Money fee2 = phone2.calculateFee();
    System.out.println("할인정책이 미적용된 통화료는 " + fee2.getAmount() + "원 입니다.");
  }
}
