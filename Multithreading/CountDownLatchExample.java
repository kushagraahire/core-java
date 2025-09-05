import java.util.concurrent.*;

public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        int numberOfTasks = 3;
        ExecutorService executor = Executors.newFixedThreadPool(numberOfTasks);

        // Latch initialized with number of tasks
        CountDownLatch latch = new CountDownLatch(numberOfTasks);

        // Submit tasks
        executor.submit(new Task(latch));
        executor.submit(new Task(latch));
        executor.submit(new Task(latch));

        // Wait for all tasks to finish
        latch.await();
        System.out.println("All tasks completed. Main thread proceeds.");

        executor.shutdown();
    }
}

class Task implements Callable<String> {
    private final CountDownLatch latch;

    public Task(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public String call() throws Exception {
        try {
            Thread.sleep(2000); // simulate work
            System.out.println(Thread.currentThread().getName() + " Executing Task");
            return "Success";
        } finally {
            latch.countDown(); // decrement latch count
        }
    }
}
