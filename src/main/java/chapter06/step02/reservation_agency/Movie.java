package src.main.java.chapter06.step02.reservation_agency;

import src.main.java.chapter06.step02.money.Money;

import java.util.List;

public class Movie {
    private String title;
    private Money fee;

    private List<DiscountCondition> discountConditionList;

    public List<DiscountCondition> getDiscountConditions() {
        return this.discountConditionList;
    }

    public Money getFee() {
        return this.fee;
    }
}
