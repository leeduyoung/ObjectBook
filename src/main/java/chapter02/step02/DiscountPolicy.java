package src.main.java.chapter02.step02;

import src.main.java.chapter02.step02.money.Money;

public interface DiscountPolicy {
    Money calculateDiscountFee(Screening screening);
}
