import java.time.LocalTime;

public class LocalTimeExample {
    public static void main(String[] args) {
        LocalTime now = LocalTime.now(); // current time
        LocalTime specificTime = LocalTime.of(14, 30, 45); // HH, mm, ss
        LocalTime parsedTime = LocalTime.parse("22:45:30"); // parse ISO-8601 string

        System.out.println(now);          // e.g., 22:15:36.123
        System.out.println(specificTime); // 14:30:45
        System.out.println(parsedTime);   // 22:45:30
    }
}
