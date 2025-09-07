import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class UnaryBinaryOperatorExample {
    public static void main(String[] args) {
        Function<Integer, Integer> square = x -> x*x;
        UnaryOperator<Integer> squareUnary = x -> x*x;

        BiFunction<Integer, Integer, Integer> sum = (a, b) -> a+b;
        BinaryOperator<Integer> sumBinary = (a, b) -> a+b;
    }
}
