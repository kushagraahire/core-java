public class SynchronizationMain {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Synchronization t1 = new Synchronization(counter);
        Synchronization t2 = new Synchronization(counter);
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Counter: "+counter.getCount());
    }

}
