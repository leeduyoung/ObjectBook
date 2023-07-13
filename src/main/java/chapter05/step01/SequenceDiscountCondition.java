package src.main.java.chapter05.step01;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class SequenceDiscountCondition {

    private int sequence;

    public boolean isSatisfiedBy(Screening screening) {
        return this.sequence == screening.getSequence();
    }
}
