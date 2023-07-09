package src.main.java.chapter04.step02;

import src.main.java.chapter04.step02.money.Money;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;


public class Movie {
    private String title; // 영화 제목
    private Duration runningTime; // 상영시간
    private Money fee; // 기본 요금
    private List<DiscountCondition> discountConditionList; // 할인 조건 목록

    private DiscountType discountType; // 할인 정책의 유형
    private Money discountAmount; // 할인 금액
    private double discountPercent; // 할인 비율

    public Movie(String title, Duration runningTime, Money fee, List<DiscountCondition> discountConditionList, DiscountType discountType, Money discountAmount, double discountPercent) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountConditionList = discountConditionList;
        this.discountType = discountType;
        this.discountAmount = discountAmount;
        this.discountPercent = discountPercent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Duration getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(Duration runningTime) {
        this.runningTime = runningTime;
    }

    public Money getFee() {
        return fee;
    }

    public void setFee(Money fee) {
        this.fee = fee;
    }

    public List<DiscountCondition> getDiscountConditionList() {
        return discountConditionList;
    }

    public void setDiscountConditionList(List<DiscountCondition> discountConditionList) {
        this.discountConditionList = discountConditionList;
    }

    public DiscountType getDiscountType() {
        return discountType;
    }

    public void setDiscountType(DiscountType discountType) {
        this.discountType = discountType;
    }

    public Money getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Money discountAmount) {
        this.discountAmount = discountAmount;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    /**
     * 할인 정책을 외부에 노출 시키고 있다.
     * - calculateAmountDiscountedFee
     * - calculatePercentDiscountedFee
     * - calculateNoneDiscountedFee
     *
     * 할인 정책이 추가되거나 제거된다면 의존하는 모든 클라이언트는 영향을 받을 것이다!
     *
     * @return
     */
    public Money calculateAmountDiscountedFee() {
        if (this.discountType != DiscountType.AMOUNT_DISCOUNT) {
            throw new IllegalArgumentException();
        }

        return this.fee.minus(this.discountAmount);
    }

    public Money calculatePercentDiscountedFee() {
        if (this.discountType != DiscountType.PERCENT_DISCOUNT) {
            throw new IllegalArgumentException();
        }

        return this.fee.minus(this.fee.times(this.discountPercent));
    }

    public Money calculateNoneDiscountedFee() {
        if (this.discountType != DiscountType.PERCENT_DISCOUNT) {
            throw new IllegalArgumentException();
        }

        return this.fee;
    }

    /**
     * 캡슐화 위반으로 DiscountCondition의 내부 구현이 외부로 노출됐기 때문에
     * Movie와 DiscountCondition 사이의 결합도는 높을 수 밖에 없다.
     *
     * - DiscountCondition이 추가된다면 Movie의 if 구문도 추가해야한다.
     * - 할인 조건의 명칭이 변경될 경우 Movie도 수정해야한다.
     * - condition의 isDiscountable 메서드의 시그니처가 변경된다면 screening에 대한 변경까지 초래할 것이다.
     *
     * @param whenScreened
     * @param sequence
     * @return
     */
    public boolean isDiscountable(LocalDateTime whenScreened, int sequence) {
        for (DiscountCondition condition : this.discountConditionList) {
            if (condition.getType() == DiscountConditionType.PERIOD) {
                return condition.isDiscountable(whenScreened.getDayOfWeek(), whenScreened.toLocalTime());
            } else {
                return condition.isDiscountable(sequence);
            }
        }

        return false;
    }

}


