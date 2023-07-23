package src.main.java.chapter06.step01.reservation_agency;

/**
 * 아래 코드의 문제점
 * - ReservationAgency와 Screening 사이의 결합도가 높다.
 * - Screening의 내부 구현을 변경할 때마다 ReservationAgency도 함께 변경될 것이다.
 *
 * 이처럼 협력하는 객체의 내부 구조에 대한 결합으로 인해 발생할 수 있는 문제를
 * 해결하기 위해서 제안된 원칙이 디미터 법칙이다.
 *
 * 클래스 내부의 메서드가 아래 조건을 만족하는 인스턴스에만 메시지를 전송하도록 수정해보자.
 *  1. this 객체
 *  2. 메서드의 매개변수
 *  3. this의 속성
 *  4. this의 속성인 컬렉션의 요소
 *  5. 메서드 내에서 생성된 지역 객체
 */

public class ReservationAgency {
    public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
        Movie movie = screening.getMovie();

        boolean discountable = false;
        for (DiscountCondition condition : movie.getDiscountConditions()) {
            if (condition.getType() == DiscountConditionType.PERIOD) {
                discountable = screening.getWhenScreened().getDayOfWeek().equals(condition.getDayOfWeek()) &&
                        condition.getStartTime().compareTo(screening.getWhenScreened().toLocalTime()) <= 0 &&
                        condition.getEndTime().compareTo(screening.getWhenScreened().toLocalTime()) >= 0;
            } else {
                discountable = condition.getSequence() == screening.getSequence();
            }

            if (discountable) {
                break;
            }
        }

        // 생략...
        return new Reservation();
    }
}
