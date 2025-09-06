@FunctionalInterface
public interface FunctionalInterfaceInheritance {
    public void abstractMethod();
}

@FunctionalInterface
interface ChildInterface extends FunctionalInterfaceInheritance{
    public void abstractMethod();
    public default void defaultMethod(){

    }
}