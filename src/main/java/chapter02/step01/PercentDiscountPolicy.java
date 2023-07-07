package src.main.java.chapter02.step01;

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
