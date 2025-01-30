import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeZoneConverter {
    public static ZonedDateTime convertToZone(ZonedDateTime zonedDateTime, String targetZoneId) {
        return zonedDateTime.withZoneSameInstant(ZoneId.of(targetZoneId));
    }
}
