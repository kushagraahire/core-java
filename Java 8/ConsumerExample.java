import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        Consumer<String> printName = x -> System.out.println(x);
        printName.accept("Kushagra");

        Consumer<String> makeUpperCase = x ->{
            System.out.println(x.toUpperCase());
        };

        makeUpperCase.andThen(printName).accept("Kushagra");
    }
}
