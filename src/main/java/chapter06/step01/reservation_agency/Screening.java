package src.main.java.chapter06.step01.reservation_agency;

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
}
