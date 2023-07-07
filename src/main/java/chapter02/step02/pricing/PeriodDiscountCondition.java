package src.main.java.chapter02.step02.pricing;

import src.main.java.chapter02.step02.DiscountCondition;
import src.main.java.chapter02.step02.Screening;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class PeriodDiscountCondition implements DiscountCondition {
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    public PeriodDiscountCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.getStartTime().getDayOfWeek().equals(this.dayOfWeek) &&
                this.startTime.compareTo(screening.getStartTime().toLocalTime()) <= 0 &&
                screening.getStartTime().toLocalTime().compareTo(this.endTime) <= 0;
    }
}
