package src.main.java.chapter02.step02;

import src.main.java.chapter02.step02.money.Money;

import java.time.Duration;

public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy discountPolicy;

    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public void changeDiscountPolicy(DefaultDiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    public Money getFee() {
        return this.fee;
    }

    public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountFee(screening));
    }
}
