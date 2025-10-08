import java.util.Stack;

public class Leetcode232 {
    private Stack<Integer> st1;
    private Stack<Integer> st2;

    public Leetcode232() {
        this.st1 = new Stack<>();
        this.st2 = new Stack<>();
    }

    public void push(int x) {
        st1.push(x);
    }


    public int pop() {
        move();
        return st2.pop();
    }

    public int peek() {
        move();
        return st2.peek();
    }

    public boolean empty() {
        move();
        return st2.isEmpty();
    }

    public void move() {
        if (st2.isEmpty()) {
            while (!st1.isEmpty()) {
                int n = st1.pop();
                st2.push(n);
            }
        }
    }
}
