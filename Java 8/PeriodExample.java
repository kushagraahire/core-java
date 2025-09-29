import java.time.LocalDate;
import java.time.Period;

public class PeriodExample {
    public static void main(String[] args) {
        LocalDate startDate = LocalDate.of(2020, 1, 1);
        LocalDate endDate = LocalDate.of(2023, 4, 15);

        // Difference between two dates
        Period period = Period.between(startDate, endDate);
        System.out.println("Years: " + period.getYears());   // 3
        System.out.println("Months: " + period.getMonths()); // 3
        System.out.println("Days: " + period.getDays());     // 14

        // Creating a period manually
        Period fiveDays = Period.ofDays(5);
        System.out.println(fiveDays); // P5D

        // Adding/Subtracting Period
        LocalDate newDate = endDate.plus(fiveDays);
        System.out.println("End Date + 5 days: " + newDate); // 2023-04-20

        // Normalizing
        Period months = Period.ofMonths(15);
        System.out.println("Before normalize: " + months);       // P15M
        System.out.println("After normalize: " + months.normalized()); // P1Y3M
    }
}
