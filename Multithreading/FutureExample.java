import java.util.concurrent.*;

public class FutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(1);

        Future<String> future = executor.submit(() -> {
            Thread.sleep(1000); // simulate some delay
            return "Some Value";
        });

        System.out.println("Doing other work while task executes...");

        // get() blocks until result is available
        String result = future.get();
        System.out.println("Result: " + result);

        executor.shutdown();
    }
}