public class VolatileExample {
    public static void main(String[] args) {
        SharedRes sharedRes = new SharedRes();
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            sharedRes.setFlagTrue();
        });

        Thread t2 = new Thread(sharedRes::printIfFlagIsTrue);
        t1.start();
        t2.start();
    }
}
class SharedRes{
    private boolean flag = false;

    public void setFlagTrue(){
        flag = true;
        System.out.println("Flag has been marked as true");
    }

    public void printIfFlagIsTrue(){
        while(!flag){
            // do nothing
        }
        System.out.println("Flag value is true");
    }
}