package src.main.java.chapter10.step05;

import src.main.java.chapter10.step05.money.Money;

public interface RatePolicy {
  Money calculateFee(Phone phone);
}
