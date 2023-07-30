package src.main.java.chapter10.step04;

import java.time.Duration;
import src.main.java.chapter10.step04.money.Money;

/**
 * 심야 할인 요금제
 *
 * 새로운 요금 방식이 추가되었다!
 * 밤 10시 이후의 통화에 대해 요금을 할인 해주는 방식이다.
 */

public class NightlyDiscountPhone extends Phone {
    private static final int LATE_NIGHT_HOUR = 22;
    private Money amount;
    private Money nightlyAmount;
    private Duration seconds;

    public NightlyDiscountPhone(Money regularAmount, Money nightlyAmount, Duration seconds, double taxRate) {
        super(taxRate);
        this.nightlyAmount = nightlyAmount;
        this.amount = regularAmount;
        this.seconds = seconds;
    }

    @Override
    public Money calculateCallFee(Call call) {
        Money result = Money.ZERO;

        if ( call.getFrom().getHour() > LATE_NIGHT_HOUR) {
            return  result.plus(this.nightlyAmount.times(call.getDuration().getSeconds() / this.seconds.getSeconds()));
        } else {
            return result.plus(this.amount.times(call.getDuration().getSeconds() / this.seconds.getSeconds()));
        }

    }

}
