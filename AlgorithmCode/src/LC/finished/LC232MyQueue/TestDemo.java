package LC.finished.LC232MyQueue;

public class TestDemo {
    public static void main(String[] args) {
        MyQueue stack = new MyQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        while (!stack.empty()){
            System.out.println(stack.pop());
        }
    }
}
