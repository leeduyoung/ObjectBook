package src.main.java.chapter02.step01;

import src.main.java.chapter02.step01.Screening;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
