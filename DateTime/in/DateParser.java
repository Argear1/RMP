import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateParser {
    public static void parseAndAddDays(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(dateString, formatter);
        date = date.plusDays(10);

        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        System.out.println("Новая дата: " + date.format(outputFormatter));
    }
}
