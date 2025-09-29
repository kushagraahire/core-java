import java.util.*;
import java.util.stream.*;

public class StreamExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Kushagra", "Rahul", "Kushagra", "Aman");

        // Filter + Map + Collect
        List<String> result = names.stream()
                .filter(name -> name.startsWith("K"))   // Intermediate
                .map(String::toUpperCase)               // Intermediate
                .distinct()                             // Intermediate
                .collect(Collectors.toList());          // Terminal

        System.out.println(result); // [KUSHAGRA]

        // Reduce Example
        int sum = Arrays.asList(1, 2, 3, 4, 5).stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println(sum); // 15

        // Parallel Stream Example
        long count = names.parallelStream()
                .filter(n -> n.length() > 5)
                .count();
        System.out.println(count); // 2
    }
}
