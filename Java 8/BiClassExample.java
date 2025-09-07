import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class BiClassExample {

    public static void main(String[] args) {
        BiPredicate<String, String> stringMatcher = (x, y) -> x.equals(y);
        System.out.println(stringMatcher.test("Kushagra", "Kushagra")); // True

        BiFunction<Integer, Integer, Integer> sum = (a, b) -> a+b;
        System.out.println(sum.apply(10, 20)); // 30

        BiConsumer<String, String> fullName = (x, y) -> {
            System.out.println(x+ " " + y);
        };
        fullName.accept("Kushagra", "Ahire");
    }
}
