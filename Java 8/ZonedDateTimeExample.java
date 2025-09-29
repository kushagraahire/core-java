import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.LocalDateTime;

public class ZonedDateTimeExample {
    public static void main(String[] args) {
        ZonedDateTime now = ZonedDateTime.now(); // current date-time with system default zone
        ZonedDateTime specificZone = ZonedDateTime.now(ZoneId.of("Asia/Kolkata")); // specific zone
        ZonedDateTime fromLocal = LocalDateTime.of(2025, 9, 23, 14, 30)
                .atZone(ZoneId.of("Europe/London"));

        System.out.println(now);          // e.g., 2025-09-23T22:25:36.123+05:30[Asia/Kolkata]
        System.out.println(specificZone); // 2025-09-23T22:25:36.123+05:30[Asia/Kolkata]
        System.out.println(fromLocal);    // 2025-09-23T14:30+01:00[Europe/London]
    }
}
