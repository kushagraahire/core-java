import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        Predicate<String> nameStartsWithK = x -> x.startsWith("K");
        System.out.println(nameStartsWithK.test("KUSHAGRA")); // True
        Predicate<String> nameEndsWithA = x -> x.endsWith("A");
        System.out.println(nameStartsWithK.and(nameEndsWithA).test("KUSHAGRA")); // True
        System.out.println(nameStartsWithK.negate().test("ADITYA")); //True
        System.out.println(nameStartsWithK.or(nameEndsWithA).test("ADITYA")); // True
        // static method of predicate interface
        System.out.println(Predicate.isEqual("KUSHAGRA").test("KUSHAGRA")); // True
    }
}
