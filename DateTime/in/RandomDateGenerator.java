import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class RandomDateGenerator {
    public static LocalDate generateRandomDate(LocalDate startInclusive, LocalDate endExclusive) {
        long startEpochDay = startInclusive.toEpochDay();
        long endEpochDay = endExclusive.toEpochDay();

        long randomEpochDay = ThreadLocalRandom.current().longs(startEpochDay, endEpochDay).findAny().getAsLong();

        return LocalDate.ofEpochDay(randomEpochDay);
    }
}
