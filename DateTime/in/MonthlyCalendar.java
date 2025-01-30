import java.time.LocalDate;
import java.time.DayOfWeek;
public class MonthlyCalendar {
    public static void printMonthlyCalendar(int month, int year) {
        LocalDate firstDay = LocalDate.of(year, month, 1);

        for (int day = 1; day <= firstDay.lengthOfMonth(); day++) {
            LocalDate date = firstDay.withDayOfMonth(day);
            String type = (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY) ? "Выходные" : "рабочии дни";
            System.out.println(date + ": " + type);
        }
    }
}
