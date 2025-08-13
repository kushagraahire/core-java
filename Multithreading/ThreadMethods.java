public class ThreadMethods extends Thread{
    @Override
    public void run() {
        System.out.println("Thread is running...");
        try {
            Thread.sleep(1000);     // Thread will wait for one second
            Thread.yield();     // gives chance to other threads to run (hints JVM)
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadMethods thread = new ThreadMethods();
        thread.start();     // starts the thread
        thread.join();      // anything below this call will run after the execution of the thread.
        thread.setPriority(MAX_PRIORITY);       // MIN MAX NORM
        thread.interrupt();     // Interrupts the thread
        thread.setDaemon(true);     // set as Daemon thread (Background Thread)
    }
}
