package src.main.java.chapter02.step01.pricing;

import src.main.java.chapter02.step01.DiscountCondition;
import src.main.java.chapter02.step01.DiscountPolicy;
import src.main.java.chapter02.step01.money.Money;
import src.main.java.chapter02.step01.Screening;

public class PercentDiscountPolicy extends DiscountPolicy {
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
