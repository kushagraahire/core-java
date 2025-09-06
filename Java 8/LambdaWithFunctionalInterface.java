public class LambdaWithFunctionalInterface {
    public static void main(String[] args) {
        Employee employee = () -> {
            return "Software Engineer";
        };
        System.out.println(employee.getDesignation());
    }
}

@FunctionalInterface
interface Employee{
    public String getDesignation();
}
