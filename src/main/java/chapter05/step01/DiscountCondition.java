package src.main.java.chapter05.step01;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class DiscountCondition {
    private DiscountConditionType type;
    private int sequence;
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    /**
     * 변경에 취약한 메서드
     * 변경에 취약한 메서드란 수정해야하는 이유를 하나 이상 가지는 클래스다.
     *  1. 새로운 할인 조건 추가
     *  2. 순번 조건을 판단하는 로직 변경
     *  3. 기간 조건을 판단하는 로직 변경
     *
     *  변경의 이유에 따라 클래스를 분리해야한다.
     *
     * @param screening
     * @return
     */
    public boolean isSatisfiedBy(Screening screening) {
        if (type == DiscountConditionType.PERIOD) {
            return isSatisfiedByPeriod(screening);
        }

        return isSatisfiedBySequence(screening);
    }

    private boolean isSatisfiedBySequence(Screening screening) {
        return this.sequence == screening.getSequence();
    }

    private boolean isSatisfiedByPeriod(Screening screening) {
        return dayOfWeek.equals(screening.getWhenScreened().getDayOfWeek()) &&
                startTime.compareTo(screening.getWhenScreened().toLocalTime()) <= 0 &&
                screening.getWhenScreened().toLocalTime().compareTo(endTime) <= 0;
    }
}
