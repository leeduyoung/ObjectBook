package src.main.java.chapter04.step01;

import src.main.java.chapter04.step01.money.Money;

public class ReservationAgency {

    public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
        Movie movie = screening.getMovie();

        boolean discountable = false;
        for (DiscountCondition condition : movie.getDiscountConditionList()) {
            if (condition.getType() == DiscountConditionType.PERIOD) {
                discountable = screening.getWhenScreened().getDayOfWeek().equals(condition.getDayOfWeek()) &&
                        condition.getStartTime().compareTo(screening.getWhenScreened().toLocalTime()) <= 0 &&
                        screening.getWhenScreened().toLocalTime().compareTo(condition.getEndTime()) <= 0;
            } else {
                discountable = condition.getSequence() == screening.getSequence();
            }

            if (discountable) {
                break;
            }
        }

        Money fee;
        if (discountable) {
            Money discountAmount = Money.ZERO;
            switch(movie.getDiscountType()) {
                case AMOUNT_DISCOUNT:
                    discountAmount = movie.getDiscountAmount();
                    break;
                case PERCENT_DISCOUNT:
                    /**
                     * Movie 객체는 getFee() 접근자를 통해 속성을 외부에 제공하고
                     * 가격이 계산되는걸 바라보고있다.
                     *
                     * 이는 Movie 객체가 자신의 데이터를 스스로 처리하도록 개선해야한다. (캡슐화)
                     */
                    discountAmount = movie.getFee().times(movie.getDiscountPercent());
                    break;
                default:
                    // NONE_DISCOUNT
                    break;
            }

            fee = movie.getFee().minus(discountAmount);
        } else {
            fee = movie.getFee();
        }

        return new Reservation(customer, screening, fee, audienceCount);
    }
}
