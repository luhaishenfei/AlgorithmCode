package LC.finished.LC232MyQueue2;

import java.util.ArrayDeque;
import java.util.Deque;

class MyStack implements Stack  {

    private final Deque deque=new ArrayDeque();

    @Override
    public void push(Object o) {
        deque.addFirst(o);
    }

    @Override
    public Object pop() {
        return deque.removeFirst();
    }

}