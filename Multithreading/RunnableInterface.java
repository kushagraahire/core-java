public class RunnableInterface implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread Name: "+Thread.currentThread().getName());
    }
}
