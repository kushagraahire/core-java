public class DefaultMethodExample implements MyInterface{
    public static void main(String[] args) {
        DefaultMethodExample obj = new DefaultMethodExample();
        obj.greet(); // Output: Hello from interface!
    }
}
interface MyInterface {
    default void greet() {
        System.out.println("Hello from interface!");
    }
}