public class Main {
    public static void main(String[] args) {
        RunnableInterface runnableInterface = new RunnableInterface();
        Thread thread = new Thread(runnableInterface);
        thread.start();

        for(int i = 0; i < 10; i++){
            System.out.println("Thread Name: "+Thread.currentThread().getName());
        }
    }
}
