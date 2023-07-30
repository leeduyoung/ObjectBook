package src.main.java.chapter10.step04;

import java.util.ArrayList;
import java.util.List;
import src.main.java.chapter10.step04.money.Money;

public abstract class Phone {
  private double taxRate;
  private List<Call> callList = new ArrayList<>();

  public Phone(double taxRate) {
    this.taxRate = taxRate;
  }

  public void call(Call call) {
    callList.add(call);
  }

  public Money calculateFee() {
    Money result = Money.ZERO;

    for (Call call : this.callList) {
      result = result.plus(calculateCallFee(call));
    }

    return result.plus(result.times(this.taxRate));
  }

  protected abstract Money calculateCallFee(Call call);
}
