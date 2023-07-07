package src.main.java.chapter02.step01.pricing;

import src.main.java.chapter02.step01.DiscountCondition;
import src.main.java.chapter02.step01.DiscountPolicy;
import src.main.java.chapter02.step01.money.Money;
import src.main.java.chapter02.step01.Screening;

public class AmountDiscountPolicy extends DiscountPolicy {
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
