package src.main.java.chapter10.step05;

import java.util.ArrayList;
import java.util.List;
import src.main.java.chapter10.step05.money.Money;

public class Phone {
    private RatePolicy ratePolicy;
    private List<Call> calls = new ArrayList<>();

    public Phone(RatePolicy ratePolicy) {
        this.ratePolicy = ratePolicy;
    }

    public void call(Call call) {
        this.calls.add(call);
    }

    public List<Call> getCalls() {
//        return Collections.unmodifiableList(calls);
        return this.calls;
    }

    public Money calculateFee() {
        return ratePolicy.calculateFee(this);
    }
}
