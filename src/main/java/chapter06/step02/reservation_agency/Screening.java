package src.main.java.chapter06.step02.reservation_agency;

import src.main.java.chapter06.step02.money.Money;

import java.time.LocalDateTime;

public class Screening {
    private Movie movie;
    private LocalDateTime whenScreened;
    private int sequence;

    public Movie getMovie() {
        return this.movie;
    }

    public LocalDateTime getWhenScreened() {
        return this.whenScreened;
    }

    public int getSequence() {
        return this.sequence;
    }

    public Money calculateFee(int audienceCount) {
        return movie.getFee().times(audienceCount);
    }
}
