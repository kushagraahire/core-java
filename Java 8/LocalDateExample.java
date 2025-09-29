import java.time.LocalDate;

public class LocalDateExample {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now(); // current date
        LocalDate dob = LocalDate.of(1999, 10, 15); // specific date
        LocalDate parsed = LocalDate.parse("2025-09-23"); // parse ISO-8601 string

        System.out.println(today);  // e.g., 2025-09-23
        System.out.println(dob);    // 1999-10-15
        System.out.println(parsed); // 2025-09-23
    }
}
