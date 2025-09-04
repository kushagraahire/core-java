
class SharedResource{
    private int data;
    private boolean hasData;

    public synchronized void  producer(int value){
        while (hasData){
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        data = value;
        hasData = true;
        System.out.println("Produced : "+data);
        notify();
    }

    public synchronized int consumer(){
        while (!hasData){
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        hasData = false;
        System.out.println("Consumed : "+data);
        notify();
        return data;
    }
}

class ProducerTask implements Runnable{
    SharedResource resource;

    public ProducerTask(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            resource.producer(10);
        }
    }
}

class ConsumerTask implements Runnable{
    SharedResource resource;

    public ConsumerTask(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            resource.consumer();
        }
    }
}
public class ThreadCommunication {

    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread thread1 = new Thread(new ProducerTask(resource));
        Thread thread2 = new Thread(new ConsumerTask(resource));

        thread1.start();
        thread2.start();
    }
}
