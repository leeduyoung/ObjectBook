package src.main.java.chapter10.step05;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import src.main.java.chapter10.step05.money.Money;

/**
 * step04에서 상속을 사용해서 구현했던 방식을
 * 합성으로 변환해보았다.
 */

public class Main {
    public static void main(String[] args){
        Call call =
                new Call(
                        LocalDateTime.of(2023, Month.JULY, 23, 23, 0, 0),
                        LocalDateTime.of(2023, Month.JULY, 23, 23, 1, 0));

        Phone phone = new Phone(new RegularPolicy(Money.wons(5), Duration.ofSeconds(10)));
        Phone phone2 = new Phone(new NightlyDiscountPolicy(Money.wons(3), Money.wons(5), Duration.ofSeconds(10)));

        phone.call(call);
        phone2.call(call);

        Money fee = phone.calculateFee();
        Money fee2 = phone2.calculateFee();

        System.out.println(fee.getAmount());
        System.out.println(fee2.getAmount());
    }
}
