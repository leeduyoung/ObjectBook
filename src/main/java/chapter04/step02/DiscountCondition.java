package src.main.java.chapter04.step02;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class DiscountCondition {

    private DiscountConditionType type;

    // 순번 할인 조건에서 사용
    private int sequence;

    // 기간 할인 조건에서 사용
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    public DiscountCondition(DiscountConditionType type, int sequence, DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.type = type;
        this.sequence = sequence;
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public DiscountConditionType getType() {
        return type;
    }

    public void setType(DiscountConditionType type) {
        this.type = type;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    /**
     * 캡슐화를 위반하고 있다.
     * 매개변수에 DiscountCondition의 속성정보를 노출하고 있다.
     *
     * 만약 해당 메서드가 변경된다면 해당 메서드를 사용하는 모든 클라이언트의 코드도
     * 함께 수정돼야 할 것이다.
     *
     * @param dayOfWeek
     * @param time
     * @return
     */
    public boolean isDiscountable(DayOfWeek dayOfWeek, LocalTime time) {
        if (type != DiscountConditionType.PERIOD) {
            throw new IllegalArgumentException();
        }

        return this.dayOfWeek.equals(dayOfWeek) &&
                this.startTime.compareTo(time) <= 0 &&
                time.compareTo(this.endTime) <= 0;
    }

    /**
     * 캡슐화를 위반하고 있다.
     * 매개변수에 DiscountCondition의 속성정보를 노출하고 있다.
     *
     * @param sequence
     * @return
     */
    public boolean isDiscountable(int sequence) {
        if (type != DiscountConditionType.SEQUENCE) {
            throw new IllegalArgumentException();
        }

        return this.sequence == sequence;
    }
}
