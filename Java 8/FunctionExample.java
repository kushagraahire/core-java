import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        Function<String, Integer> getLength = x -> x.length();
        System.out.println(getLength.apply("Test")); // 4

        Function<Integer, Integer> sum = x -> x + 10;
        Function<Integer, Integer> product = x -> x * 10;
        System.out.println(sum.andThen(product).apply(24)); // 340
        System.out.println(product.andThen(sum).apply(24)); // 250

        System.out.println(sum.compose(product).apply(24)); // 250

        System.out.println(Function.identity().apply("Test")); // Test
    }
}
