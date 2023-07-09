package src.main.java.chapter04.step02;

import src.main.java.chapter04.step02.money.Money;

import java.time.LocalDateTime;

public class Screening {
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public LocalDateTime getWhenScreened() {
        return whenScreened;
    }

    public void setWhenScreened(LocalDateTime whenScreened) {
        this.whenScreened = whenScreened;
    }

    /**
     * Movie 객체와 강하게 결합해있다.
     *
     * @param audienceCount
     * @return
     */
    public Money calculateFee(int audienceCount) {
        switch(this.movie.getDiscountType()) {
            case AMOUNT_DISCOUNT:
                if (movie.isDiscountable(this.whenScreened, this.sequence)) {
                    return movie.calculateAmountDiscountedFee();
                }
                break;
            case PERCENT_DISCOUNT:
                if (movie.isDiscountable(this.whenScreened, this.sequence)) {
                    return movie.calculatePercentDiscountedFee();
                }
                break;
            default:
                return movie.calculateNoneDiscountedFee();
        }

        return movie.calculateNoneDiscountedFee();
    }
}
