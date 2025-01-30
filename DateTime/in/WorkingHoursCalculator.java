import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Duration;

public class WorkingHoursCalculator {
    public static long calculateWorkingHours(LocalDateTime start, LocalDateTime end) {
        // Убедимся, что начальная дата раньше конечной
        if (start.isAfter(end)) {
            throw new IllegalArgumentException("Время начала должно быть раньше времени окончания");
        }

        long totalHours = 0;
        LocalDateTime current = start;

        // Устанавливаем границы рабочего времени
        LocalTime workStart = LocalTime.of(9, 0); // 9:00
        LocalTime workEnd = LocalTime.of(17, 0); // 17:00

        while (current.isBefore(end)) {
            // Проверяем, является ли текущий день рабочим днем
            if (current.getDayOfWeek() != DayOfWeek.SATURDAY && current.getDayOfWeek() != DayOfWeek.SUNDAY) {
                // Устанавливаем время начала и конца рабочего дня
                LocalDateTime startOfWorkDay = current.with(workStart);
                LocalDateTime endOfWorkDay = current.with(workEnd);

                // Корректируем начальную и конечную точки
                if (current.isBefore(startOfWorkDay)) {
                    current = startOfWorkDay; // Если текущее время до начала рабочего дня, переходим к началу рабочего дня
                }

                if (current.isBefore(endOfWorkDay) && end.isAfter(current)) {
                    // Если текущее время попадает в рабочие часы, считаем рабочие часы
                    LocalDateTime effectiveEnd = end.isBefore(endOfWorkDay) ? end : endOfWorkDay;
                    totalHours += Duration.between(current, effectiveEnd).toHours();
                }
            }
            // Переходим к следующему дню
            current = current.plusDays(1).with(workStart);
        }

        return totalHours;
    }
}
