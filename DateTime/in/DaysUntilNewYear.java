import java.time.LocalDate;
public class DaysUntilNewYear {
    public static long daysUntilNewYear() {
        LocalDate today = LocalDate.now();
        LocalDate newYear = LocalDate.of(today.getYear() + 1, 1, 1);
        return today.until(newYear).getDays();
    }
}
