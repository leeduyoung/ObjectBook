package src.main.java.chapter10.step02;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import src.main.java.chapter10.step02.money.Money;

/**
 * 심야 할인 요금제
 *
 * 새로운 요금 방식이 추가되었다!
 * 밤 10시 이후의 통화에 대해 요금을 할인 해주는 방식이다.
 */

public class NightlyDiscountPhone {
    private static final int LATE_NIGHT_HOUR = 22;
    private Money regularAmount; // 일반 요금 (단위 요금)
    private Money nightlyAmount; // 심야 요금 (단위 요금)
    private Duration seconds; // 단위 시간
    private List<Call> callList = new ArrayList<>(); // 통화 목록

    public NightlyDiscountPhone(Money regularAmount, Money nightlyAmount, Duration seconds) {
        this.regularAmount = regularAmount;
        this.nightlyAmount = nightlyAmount;
        this.seconds = seconds;
    }
    
    public void call(Call call) {
        callList.add(call);
    }

    public List<Call> getCallList() {
        return this.callList;
    }

    public Money getRegularAmount() {
        return this.regularAmount;
    }

    public Money getNightlyAmount() {
        return this.nightlyAmount;
    }

    public Duration getSeconds() {
        return this.seconds;
    }

    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : this.callList) {
            if (call.getFrom().getHour() > LATE_NIGHT_HOUR) {
                result = result.plus(this.nightlyAmount.times(call.getDuration().getSeconds() / this.seconds.getSeconds()));
            } else {
                result = result.plus(this.regularAmount.times(call.getDuration().getSeconds() / this.seconds.getSeconds()));
            }
        }
        
        return result;
    }
}
