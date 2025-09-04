
class Pen {
    public synchronized void writeWithPenAndPaper(Paper paper) {
        System.out.println(Thread.currentThread().getName() + " is using pen and trying to acquire paper");
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        paper.finishedWriting();
    }

    public synchronized void finishedWriting() {
        System.out.println(Thread.currentThread().getName() + " finished using pen");
    }
}

class Paper {
    public synchronized void writeWithPaperAndPen(Pen pen) {
        System.out.println(Thread.currentThread().getName() + " is using paper and trying to acquire pen");
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        pen.finishedWriting();
    }

    public synchronized void finishedWriting() {
        System.out.println(Thread.currentThread().getName() + " finished using paper");
    }
}

class Task1 implements Runnable {
    private Pen pen;
    private Paper paper;

    public Task1(Pen pen, Paper paper) {
        this.pen = pen;
        this.paper = paper;
    }

    @Override
    public void run() {
        synchronized (pen){
            paper.writeWithPaperAndPen(pen);
        }
    }
}

class Task2 implements Runnable {
    private Pen pen;
    private Paper paper;

    public Task2(Pen pen, Paper paper) {
        this.pen = pen;
        this.paper = paper;
    }

    @Override
    public void run() {
        synchronized (paper){
            pen.writeWithPenAndPaper(paper);
        }
    }
}

public class DeadLockExample {

    public static void main(String[] args) {
        Pen pen = new Pen();
        Paper paper = new Paper();
        Thread thread1 = new Thread(new Task1(pen, paper), "Thread1");
        Thread thread2 = new Thread(new Task2(pen, paper), "Thread2");
        thread1.start();
        thread2.start();
    }
}
