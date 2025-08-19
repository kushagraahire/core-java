import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairnessLock {
    Lock lock = new ReentrantLock(true);
    public void accessResource(){
       lock.lock();
       try {
           System.out.println(Thread.currentThread().getName()+" : acquired the lock");
           Thread.sleep(1000);
       } catch (InterruptedException e) {
           Thread.currentThread().interrupt();
       }finally {
           lock.unlock();
           System.out.println(Thread.currentThread().getName()+" : released the lock");
       }
    }

    public static void main(String[] args) {
        FairnessLock lock = new FairnessLock();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                lock.accessResource();
            }
        };
        Thread thread1 = new Thread(runnable, "1");
        Thread thread2 = new Thread(runnable, "2");
        Thread thread3 = new Thread(runnable, "3");

        thread1.start();
        thread2.start();
        thread3.start();
    }

}
