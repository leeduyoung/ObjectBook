package src.main.java.chapter02.step02.pricing;

import src.main.java.chapter02.step02.DiscountPolicy;
import src.main.java.chapter02.step02.Screening;
import src.main.java.chapter02.step02.money.Money;

public class NoneDiscountPolicy implements DiscountPolicy {

    public Money calculateDiscountFee(Screening screening) {
        return Money.ZERO;
    }
}
