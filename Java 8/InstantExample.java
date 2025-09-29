import java.time.Instant;

public class InstantExample {
    public static void main(String[] args) {
        Instant now = Instant.now();                   // current timestamp
        Instant specific = Instant.parse("2025-09-23T17:30:45Z"); // parse ISO-8601
        Instant plusSeconds = now.plusSeconds(60);    // add seconds

        System.out.println(now);          // e.g., 2025-09-23T16:50:36.123Z
        System.out.println(specific);     // 2025-09-23T17:30:45Z
        System.out.println(plusSeconds);  // 2025-09-23T16:51:36.123Z
    }
}
