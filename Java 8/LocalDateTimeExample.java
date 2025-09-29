import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;

public class LocalDateTimeExample {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now(); // current date and time
        LocalDateTime specific = LocalDateTime.of(2025, 9, 23, 14, 30, 45); // YYYY, MM, DD, HH, mm, ss
        LocalDateTime fromDateTime = LocalDateTime.of(LocalDate.of(2025, 9, 23), LocalTime.of(14, 30));

        System.out.println(now);          // e.g., 2025-09-23T22:20:36.123
        System.out.println(specific);     // 2025-09-23T14:30:45
        System.out.println(fromDateTime); // 2025-09-23T14:30
    }
}
