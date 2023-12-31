package src.main.java.chapter04.step01;

import src.main.java.chapter04.step01.money.Money;

import java.time.Duration;
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

    /**
     * 캡슐화 위반
     * Movie 내부에 Money 타입의 fee라는 이름의 인스턴스 변수가
     * 존재한다는 사실을 퍼블릭 인터페이스에 노골적으로 드러내고 있다.
     *
     * @param fee
     */
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
}


