package src.main.java.chapter02.step01;

public class NoneDiscountPolicy extends DiscountPolicy {
    @Override
    protected Money getDiscountFee(Screening screening) {
        return Money.ZERO;
    }
}
