import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(9);
        for(int i = 1; i < 10; i++){
            int finalI = i;
            executor.submit(() -> {
                System.out.println(factorial(finalI));
            });
        }
        executor.shutdown();
    }

    private static int factorial(int n){
        int factorial = 1;
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for(int i = 1; i <= n; i++){
            factorial *= i;
        }
        return factorial;
    }
}
