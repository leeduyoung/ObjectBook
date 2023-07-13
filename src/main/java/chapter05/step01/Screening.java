package src.main.java.chapter05.step01;


import src.main.java.chapter05.step01.money.Money;

import java.time.LocalDateTime;

/**
 * 영화를 예매할 책임을 맡으며 그 결과로 Reservation 인스턴스를 생성할 책임을 수행한다.
 * Screening객체는 예매에 대한 정보 전문가인 동시에 Reservation 창조자이다.
 */
public class Screening {
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    public int getSequence() {
        return sequence;
    }

    public LocalDateTime getWhenScreened() {
        return whenScreened;
    }

    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    private Money calculateFee(int audienceCount) {
        return movie.calculateMovieFee(this).times(audienceCount);
    }

    public Movie getMovie() {
        return this.movie;
    }
}
