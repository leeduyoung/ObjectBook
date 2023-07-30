package src.main.java.chapter10.step04;

import java.time.Duration;
import src.main.java.chapter10.step04.money.Money;

public class RegularPhone extends Phone {
  private Money amount;
  private Duration seconds;

  public RegularPhone(Money amount, Duration seconds, double taxRate) {
    super(taxRate);
    this.amount = amount;
    this.seconds = seconds;
  }


  public Money getAmount() {
    return this.amount;
  }

  public Duration getSeconds() {
    return this.seconds;
  }


  @Override
  public Money calculateCallFee(Call call) {
    return this.amount.times(call.getDuration().getSeconds() / this.seconds.getSeconds());
  }
}
