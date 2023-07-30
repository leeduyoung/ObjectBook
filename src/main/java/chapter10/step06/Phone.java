package src.main.java.chapter10.step06;

import java.util.ArrayList;
import java.util.List;

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
