package src.main.java.chapter10.step06;

public class RateDiscountPolicy extends AdditionalRatePolicy {
    private double discountRatio;

    public RateDiscountPolicy(RatePolicy ratePolicy, double discountRatio) {
        super(ratePolicy);
        this.discountRatio = discountRatio;
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return fee.minus(fee.times(this.discountRatio));
    }
}
