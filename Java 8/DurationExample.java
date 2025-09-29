import java.time.*;

public class DurationExample {
    public static void main(String[] args) {
        Duration twoHours = Duration.ofHours(2);     // 2 hours
        Duration fiveMinutes = Duration.ofMinutes(5);// 5 minutes
        Duration thirtySeconds = Duration.ofSeconds(30);
        Duration millis = Duration.ofMillis(500);
        Duration nanos = Duration.ofNanos(1000);

        System.out.println(twoHours);     // PT2H
        System.out.println(fiveMinutes);  // PT5M
        System.out.println(thirtySeconds);// PT30S
        System.out.println(millis);       // PT0.5S
        System.out.println(nanos);        // PT0.000001S
    }
}
