package src.main.java.chapter05.step01;

import src.main.java.chapter05.step01.money.Money;

import java.time.Duration;

public class AmountDiscountMovie  extends Movie {
    private Money discountAmount;

    public AmountDiscountMovie(String title, Duration runningTime, Money fee, Money discountAmount, DiscountConditionInterface... discountConditions) {
        super(title, runningTime, fee, discountConditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money calculateDiscountAmount() {
        return this.discountAmount;
    }
}
