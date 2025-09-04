import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorInvokeExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        Callable<Integer> callable1 = () ->{
            Thread.sleep(200);
            System.out.println("Task 1");
            return 1;
        };
        Callable<Integer> callable2 = () ->{
            Thread.sleep(200);
            System.out.println("Task 2");
            return 2;
        };
        Callable<Integer> callable3 = () ->{
            Thread.sleep(200);
            System.out.println("Task 3");
            return 3;
        };

        List<Callable<Integer>> list = Arrays.asList(callable1,callable2, callable3);

        try {
            List<Future<Integer>> futures = executor.invokeAll(list);
            for(Future<Integer> future : futures){
                System.out.println(future.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        // invoke any
        Integer i = null;
        try {
            i = executor.invokeAny(list);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println(i);
        executor.shutdown();
    }
}
