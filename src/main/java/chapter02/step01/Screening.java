package src.main.java.chapter02.step01;

import src.main.java.chapter02.step01.money.Money;

import java.time.LocalDateTime;

public class Screening {
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    public Screening(Movie movie, int sequence, LocalDateTime whenScreend) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreened = whenScreend;
    }

    public LocalDateTime getStartTime() {
        return this.whenScreened;
    }

    public boolean isSequence(int sequence) {
        return this.sequence == sequence;
    }

    public Money getMovieFee() {
        return movie.getFee();
    }

    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    private Money calculateFee(int audienceCount) {
        return this.movie.calculateMovieFee(this).times(audienceCount);
    }
}

