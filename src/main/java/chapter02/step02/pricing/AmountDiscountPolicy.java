package src.main.java.chapter02.step02.pricing;

import src.main.java.chapter02.step02.DiscountCondition;
import src.main.java.chapter02.step02.DefaultDiscountPolicy;
import src.main.java.chapter02.step02.Screening;
import src.main.java.chapter02.step02.money.Money;

public class AmountDiscountPolicy extends DefaultDiscountPolicy {
    private Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountFee(Screening screening) {
        return this.discountAmount;
    }
}
