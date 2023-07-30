package src.main.java.chapter10.step03;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import src.main.java.chapter10.step03.money.Money;

public class Phone {
    private Money amount;
    private Duration seconds;
    private List<Call> callList = new ArrayList<>();
    private double taxRate;

    public Phone(Money amount, Duration seconds, double taxRate) {
        this.amount = amount;
        this.seconds = seconds;
        this.taxRate = taxRate;
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

        return result.plus(result.times(taxRate));
    }
}
