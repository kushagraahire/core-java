import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {
    private int counter;

    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    Lock readLock = readWriteLock.readLock();
    Lock writeLock = readWriteLock.writeLock();

    public void increment(){
        writeLock.lock();
        try{
            counter++;
        }finally {
            writeLock.unlock();
        }
    }

    public int getCounter(){
        readLock.lock();
        try{
            return counter;
        }finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) {
        ReadWriteLockExample readWriteLockExample = new ReadWriteLockExample();

        Runnable read = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++){
                    System.out.println(Thread.currentThread().getName()+" Reading counter: "+readWriteLockExample.getCounter());
                }
            }
        };

        Runnable write = new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10; i++){
                    System.out.println(Thread.currentThread().getName()+" Incremented");
                    readWriteLockExample.increment();
                }
            }
        };

        Thread thread1 = new Thread(write, "Thread1");
        Thread thread2 = new Thread(read, "Thread2");
        Thread thread3 = new Thread(read, "Thread3");

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("final count: "+readWriteLockExample.getCounter());

    }

}
