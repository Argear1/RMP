import java.time.LocalDate;

 class DateComparison {
    public static String compareDates(LocalDate date1, LocalDate date2) {
        if (date1.isBefore(date2)) {
            return date1 + " до " + date2;
        } else if (date1.isAfter(date2)) {
            return date1 + " после" + date2;
        } else {
            return date1 + " равно " + date2;
        }
    }
}
