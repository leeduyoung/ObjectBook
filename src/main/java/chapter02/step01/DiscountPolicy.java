package src.main.java.chapter02.step01;

import src.main.java.chapter02.step01.money.Money;

import java.util.Arrays;
import java.util.List;

public abstract class DiscountPolicy {
    private List<DiscountCondition> conditionList;

    public DiscountPolicy(DiscountCondition ... conditions) {
        this.conditionList = Arrays.asList(conditions);
    }

    public Money calculateDiscountFee(Screening screening) {
        for(DiscountCondition condition : conditionList) {
            if (condition.isSatisfiedBy(screening)) {
                return getDiscountFee(screening);
            }
        }

        return Money.ZERO;
    }

    abstract protected Money getDiscountFee(Screening screening);
}
