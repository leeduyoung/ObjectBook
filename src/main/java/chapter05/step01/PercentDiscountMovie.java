package src.main.java.chapter05.step01;

import src.main.java.chapter05.step01.money.Money;

import java.time.Duration;

public class PercentDiscountMovie extends Movie {
    private double discountPercent;

    public PercentDiscountMovie(String title, Duration runningTime, Money fee, double discountPercent, DiscountConditionInterface... discountConditions) {
        super(title, runningTime, fee, discountConditions);
        this.discountPercent = discountPercent;
    }

    @Override
    protected Money calculateDiscountAmount() {
        return this.getFee().times(this.discountPercent);
    }
}
