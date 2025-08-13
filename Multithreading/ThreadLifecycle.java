public class ThreadLifecycle extends Thread{
    @Override
    public void run() {
        try {
            Thread.sleep(2000);     // For 2 seconds thread will be in TIMED WAITING state;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadLifecycle thread = new ThreadLifecycle();     // NEW
        thread.start();     // RUNNABLE
        thread.join();  // After this TERMINATED state
    }
}
