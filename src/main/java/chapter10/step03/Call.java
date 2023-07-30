package src.main.java.chapter10.step03;

import java.time.Duration;
import java.time.LocalDateTime;

public class Call {
    private LocalDateTime from;
    private LocalDateTime to;

    public Call(LocalDateTime from, LocalDateTime to) {
        this.from = from;
        this.to = to;
    }

    public Duration getDuration() {
        return Duration.between(this.from, this.to);
    }

    public LocalDateTime getFrom() {
        return this.from;
    }
}
