import java.time.LocalDateTime;
import java.time.Duration;

public class TimeUntilEventCalculator {
    public static Duration timeUntilEvent(LocalDateTime event) {
        return Duration.between(LocalDateTime.now(), event);
    }
}
