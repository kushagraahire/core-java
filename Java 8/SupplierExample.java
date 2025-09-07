import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        Supplier<String> name = () -> "Kushagra";
        System.out.println(name.get());
    }
}
