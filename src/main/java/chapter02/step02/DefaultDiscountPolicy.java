package src.main.java.chapter02.step02;

import src.main.java.chapter02.step02.money.Money;

import java.util.Arrays;
import java.util.List;

public abstract class DefaultDiscountPolicy implements DiscountPolicy {
    private List<DiscountCondition> conditionList;

    public DefaultDiscountPolicy(DiscountCondition... conditions) {
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
