import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeFormatterExample {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();

        // Predefined ISO format
        DateTimeFormatter isoFormatter = DateTimeFormatter.ISO_DATE_TIME;
        System.out.println("ISO Format: " + now.format(isoFormatter));

        // Custom pattern
        DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedDate = now.format(customFormatter);
        System.out.println("Custom Format: " + formattedDate);

        // Parsing string into LocalDateTime
        String dateStr = "29-09-2025 18:45";
        DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime parsedDate = LocalDateTime.parse(dateStr, parser);
        System.out.println("Parsed DateTime: " + parsedDate);

        // Using Locale
        DateTimeFormatter localeFormatter = DateTimeFormatter.ofPattern("EEEE, MMM dd yyyy", Locale.FRENCH);
        System.out.println("French Locale: " + now.format(localeFormatter));
    }
}
