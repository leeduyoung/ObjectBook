package src.main.java.chapter02.step01.pricing;

import src.main.java.chapter02.step01.Screening;
import src.main.java.chapter02.step01.DiscountCondition;

public class SequenceDiscountCondition implements DiscountCondition {
    private int sequence;

    public SequenceDiscountCondition(int sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.isSequence(sequence);
    }
}
