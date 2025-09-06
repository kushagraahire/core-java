public class LambdaFunction {
    //Example 1
    public void print(){
        System.out.println("Hello World");
    }

   // () -> {
   //     System.out.println("Hello World");
   // }

    //() -> System.out.println("Hello World");

    //Example 2
    public void add(int a, int b){
        System.out.println(a+b);
    }

    // (int a, int b) -> System.out.println(a+b);

    // (a, b) -> System.out.println(a+b);

    //Example 3
    public int getStringLength(String s){
        return s.length();
    }

    // (String s) -> return s.length();

}
