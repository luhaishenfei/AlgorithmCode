package LC.LC232MyQueue;


import java.util.Deque;
import java.util.LinkedList;

class MyQueue {


    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public MyQueue() {
        stack1 = new LinkedList();
        stack2 = new LinkedList();
    }


    public void push(int x) {
        stack1.push(x);
    }


    //返回栈顶元素，并在进程中删除它。
    public int pop() {
        if (stack2.peek()==null) {
            while (stack1.peek()!=null) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    //返回栈顶元素，不在堆栈中删除它。
    public int peek() {
        if (stack2.peek()==null) {
            while (stack1.peek()!=null) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.peek()==null && stack2.peek()==null ? true : false;
    }
}
/*
class MyQueue {


    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack();
        stack2 = new Stack();
        Deque a = new ArrayDeque();
        Deque b = new LinkedList();
    }


    public void push(int x) {
        stack1.push(x);
    }


    //返回栈顶元素，并在进程中删除它。
    public int pop() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    //返回栈顶元素，不在堆栈中删除它。
    public int peek() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.empty() && stack2.empty() ? true : false;
    }
}

 */