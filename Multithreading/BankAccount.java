import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance = 100;
    private final Lock lock = new ReentrantLock();

    public void withdraw(int amount){
        System.out.println(Thread.currentThread().getName()+" is trying to withdraw "+amount);

        try{
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){
                if(balance >= amount){
                    System.out.println(Thread.currentThread().getName()+" proceeding with withdrawal");
                    try {
                        Thread.sleep(10000);        // simulating business logic

                        balance -= amount;
                        System.out.println(Thread.currentThread().getName() + " Withdrawal successful, remaining amount: " + amount);
                    }catch (InterruptedException e) {
                        System.out.println(e);
                        Thread.currentThread().interrupt();
                    }finally {
                        lock.unlock();
                    }
                }else {
                    System.out.println(Thread.currentThread().getName()+" insufficient balance");
                }
            }else {
                System.out.println(Thread.currentThread().getName()+" could not acquire lock");
            }
        } catch (Exception e){
            System.out.println(e);
            Thread.currentThread().interrupt();
        }
    }
}
