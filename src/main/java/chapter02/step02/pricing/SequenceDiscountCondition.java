package src.main.java.chapter02.step02.pricing;

import src.main.java.chapter02.step02.DiscountCondition;
import src.main.java.chapter02.step02.Screening;

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
