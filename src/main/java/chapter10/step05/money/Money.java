package src.main.java.chapter10.step05.money;

import java.math.BigDecimal;

/**
 * 참고
 * BigDecimal은 Java에서 정확한 십진 연산을 수행하기 위한 클래스이다.
 *
 * 일반적으로 부동 소수점 숫자(float 또는 double)를 사용할 때 발생하는 부정확성과
 * 정밀도 손실 문제를 해결하기 위해 BigDecimal을 사용합니다.
 * 이 클래스는 소수점 이하의 숫자를 정확하게 처리할 수 있으며, 높은 정밀도를 유지합니다.
 */
public class Money {
    public static final Money ZERO = Money.wons(0);

    private final BigDecimal amount;
    Money(BigDecimal amount) {
        this.amount = amount;
    }

    public static Money wons(long amount) {
        return new Money(BigDecimal.valueOf(amount));
    }

    public static Money wons(double amount) {
        return new Money(BigDecimal.valueOf(amount));
    }

    public Money plus(Money amount) {
        return new Money(this.amount.add(amount.amount));
    }

    public Money minus(Money amount) {
        return new Money(this.amount.subtract(amount.amount));
    }

    public Money times(double percent) {
        return new Money(this.amount.multiply(BigDecimal.valueOf(percent)));
    }

    public boolean isLessThan(Money other) {
        return this.amount.compareTo(other.amount) < 0;
    }

    public boolean isGreaterThanOrEqual(Money other) {
        return this.amount.compareTo(other.amount) >= 0;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }
}
