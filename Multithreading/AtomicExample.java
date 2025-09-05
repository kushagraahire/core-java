import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {
    public static void main(String[] args) throws InterruptedException {
        CounterExample counter = new CounterExample();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++){
                counter.increment();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++){
                counter.increment();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Counter: "+counter.getCounter());
    }
}

class CounterExample{
    private final AtomicInteger counter = new AtomicInteger(0);

    public void increment(){
        counter.incrementAndGet();
    }

    public int getCounter(){
       return counter.get();
    }
}