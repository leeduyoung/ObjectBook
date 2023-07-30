package src.main.java.chapter10.step05;

import java.time.Duration;
import src.main.java.chapter10.step05.money.Money;

public class RegularPolicy extends BasicRatePolicy {
    private Money amount;
    private Duration seconds;

    public RegularPolicy(Money amount, Duration seconds) {
        this.amount = amount;
        this.seconds = seconds;
    }

    @Override
    protected Money calculateCallFee(Call call) {
        return amount.times(call.getDuration().getSeconds() / this.seconds.getSeconds());
    }
}
