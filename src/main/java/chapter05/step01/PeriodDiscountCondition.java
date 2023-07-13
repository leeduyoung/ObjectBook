package src.main.java.chapter05.step01;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class PeriodDiscountCondition {

    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    public boolean isSatisfiedBy(Screening screening) {
        return dayOfWeek.equals(screening.getWhenScreened().getDayOfWeek()) &&
                startTime.compareTo(screening.getWhenScreened().toLocalTime()) <= 0 &&
                screening.getWhenScreened().toLocalTime().compareTo(endTime) <= 0;
    }

}
