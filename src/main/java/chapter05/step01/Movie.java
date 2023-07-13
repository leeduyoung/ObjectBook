package src.main.java.chapter05.step01;

import src.main.java.chapter05.step01.money.Money;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
//
//public class Movie {
//    private String title;
//    private Duration runningTime;
//    private Money fee;
//    private List<DiscountConditionInterface> discountConditionList;
//
//    private DiscountType discountType;
//    private Money discountAmount;
//    private double discountPercent;
//
//    public Money calculateMovieFee(Screening screening) {
//        if (isDiscountable(screening)) {
//            return this.fee.minus(calculateDiscountAmount());
//        }
//
//        return this.fee;
//    }
//
//    private Money calculateDiscountAmount() {
//        switch(this.discountType) {
//            case AMOUNT_DISCOUNT:
//                return calculateAmountDiscountAmount();
//            case PERCENT_DISCOUNT:
//                return calculatePercentDiscountAmount();
//            case NONE_DISCOUNT:
//                return calculateNoneDiscountAmount();
//        }
//
//        throw new IllegalStateException();
//    }
//
//    private Money calculateNoneDiscountAmount() {
//        return Money.ZERO;
//    }
//
//    private Money calculatePercentDiscountAmount() {
//        return this.fee.times(this.discountPercent);
//    }
//
//    private Money calculateAmountDiscountAmount() {
//        return this.discountAmount;
//    }
//
//    private boolean isDiscountable(Screening screening) {
//        return this.discountConditionList.stream().anyMatch(discountCondition -> discountCondition.isSatisfiedBy(screening));
//    }
//}

public abstract class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountConditionInterface> discountConditionList;

    public Movie(String title, Duration runningTime, Money fee, DiscountConditionInterface ... discountConditions) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountConditionList = Arrays.asList(discountConditions);
    }

    public Money calculateMovieFee(Screening screening) {
        if (isDiscountable(screening)) {
            return this.fee.minus(calculateDiscountAmount());
        }

        return this.fee;
    }

    private boolean isDiscountable(Screening screening) {
        return this.discountConditionList.stream().anyMatch(discountCondition -> discountCondition.isSatisfiedBy(screening));
    }

    abstract protected Money calculateDiscountAmount();

    protected Money getFee() {
        return this.fee;
    }

    public List<DiscountConditionInterface> getDiscountConditions() {
        return this.discountConditionList;
    }
}