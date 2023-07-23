package src.main.java.chapter10.step01;

import src.main.java.chapter10.step01.money.Money;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Phone {
    private Money amount;
    private Duration seconds;
    private List<Call> callList = new ArrayList<>();

    public Phone(Money amount, Duration seconds) {
        this.amount = amount;
        this.seconds = seconds;
    }

    public void call(Call call) {
        callList.add(call);
    }

    public List<Call> getCallList() {
        return this.callList;
    }

    public Money getAmount() {
        return this.amount;
    }

    public Duration getSeconds() {
        return this.seconds;
    }

    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : this.callList) {
            result = result.plus(this.amount.times(call.getDuration().getSeconds() / this.seconds.getSeconds()));
        }

        return result;
    }
}
