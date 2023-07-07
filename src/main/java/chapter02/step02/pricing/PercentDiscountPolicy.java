package src.main.java.chapter02.step02.pricing;

import src.main.java.chapter02.step02.DiscountCondition;
import src.main.java.chapter02.step02.DefaultDiscountPolicy;
import src.main.java.chapter02.step02.DiscountPolicy;
import src.main.java.chapter02.step02.Screening;
import src.main.java.chapter02.step02.money.Money;

public class PercentDiscountPolicy extends DefaultDiscountPolicy {
    private double discountPercent;

    public PercentDiscountPolicy(double discountPercent, DiscountCondition... conditions) {
        super(conditions);
        this.discountPercent = discountPercent;
    }

    @Override
    protected Money getDiscountFee(Screening screening) {
        return screening.getMovieFee().times(discountPercent);
    }

}
