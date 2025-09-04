import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorExample {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
        scheduler.scheduleWithFixedDelay(
                () -> System.out.println("Tasks run sequentially, each with a 5-second delay after the previous one completes")
        ,5000, 5000, TimeUnit.MILLISECONDS);

        scheduler.schedule(() -> {
            System.out.println("Shutting down scheduler");
            scheduler.shutdown();
        }, 20000, TimeUnit.MILLISECONDS);
    }
}
