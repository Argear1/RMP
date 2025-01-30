import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        // 1.
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println("1. Текущая дата и время: " + currentDateTime.format(formatter));

        // 2.
        LocalDate date1 = LocalDate.of(2023, 1, 1);
        LocalDate date2 = LocalDate.of(2024, 1, 1);
        System.out.println("2. Сравнение дат: " + DateComparison.compareDates(date1, date2));

        // 3.
        System.out.println("3. Дней до Нового года: " + DaysUntilNewYear.daysUntilNewYear());

        // 4.
        int year = 2024;
        System.out.println("4. Год " + year + " является високосным: " + LeapYearChecker.isLeapYear(year));

        // 5.
        int month = 12;
        System.out.println("5. Выходные за месяц: " + WeekendCounter.countWeekends(month, 2023));

        // 6.
        ExecutionTimeCalculator.measureExecutionTime(() -> {
            for (int i = 0; i < 1_000_000; i++) {
            }
        });

        // 7.
        String dateString = "25-12-2023";
        System.out.print("7. Новая дата после добавления 10 дней: ");
        DateParser.parseAndAddDays(dateString);

        // 8.
        ZonedDateTime utcTime = ZonedDateTime.now(ZoneId.of("UTC"));
        ZonedDateTime moscowTime = TimeZoneConverter.convertToZone(utcTime, "Europe/Moscow");
        System.out.println("8. Время в Москве: " + moscowTime);

        // 9.
        LocalDate birthDate = LocalDate.of(1990, 5, 15);
        System.out.println("9. Возраст: " + AgeCalculator.calculateAge(birthDate) + " лет");

        // 10.
        System.out.println("10. Календарь на декабрь 2023:");
        MonthlyCalendar.printMonthlyCalendar(12, 2023);

        // 11.
        LocalDate randomStart = LocalDate.of(2023, 1, 1);
        LocalDate randomEnd = LocalDate.of(2023, 12, 31);
        LocalDate randomDate = RandomDateGenerator.generateRandomDate(randomStart, randomEnd);
        System.out.println("11. Случайная дата в диапазоне: " + randomDate);

        // 12.
        LocalDateTime eventTime = LocalDateTime.of(2026, 1, 1, 0, 0);
        Duration durationUntilEvent = TimeUntilEventCalculator.timeUntilEvent(eventTime);
        System.out.println("12. Время до события: " + durationUntilEvent.toHours() + " часов, "
                + durationUntilEvent.toMinutesPart() + " минут и "
                + durationUntilEvent.toSecondsPart() + " секунд.");

        // 13.
        LocalDateTime workStart = LocalDateTime.of(2023, 12, 25, 8, 0); // Начало рабочего времени
        LocalDateTime workEnd = LocalDateTime.of(2023, 12, 27, 18, 0); // Конец рабочего времени

        long workingHours = WorkingHoursCalculator.calculateWorkingHours(workStart, workEnd);
        System.out.println("13. Рабочие часы: " + workingHours);

        // 14.
        Locale locale = new Locale("ru");
        System.out.println("14. Форматированная дата: "
                + LocaleAwareFormatter.formatWithLocale(currentDateTime.toLocalDate(), locale));

        // 15.
        System.out.println("15. День недели для текущей даты: "
                + WeekdayNameFinder.getWeekdayName(currentDateTime.toLocalDate()));
    }
}
