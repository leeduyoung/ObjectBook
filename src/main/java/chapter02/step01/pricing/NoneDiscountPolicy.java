package src.main.java.chapter02.step01.pricing;

import src.main.java.chapter02.step01.DiscountPolicy;
import src.main.java.chapter02.step01.money.Money;
import src.main.java.chapter02.step01.Screening;

public class NoneDiscountPolicy extends DiscountPolicy {
    @Override
    protected Money getDiscountFee(Screening screening) {
        return Money.ZERO;
    }
}
