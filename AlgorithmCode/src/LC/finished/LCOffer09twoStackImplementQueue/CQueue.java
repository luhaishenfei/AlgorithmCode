package LC.finished.LCOffer09twoStackImplementQueue;

import java.util.ArrayDeque;
import java.util.Deque;

/*
> 2022/11/11 09:28:06
解答成功:
	执行耗时:36 ms,击败了85.86% 的Java用户
	内存消耗:47.7 MB,击败了94.48% 的Java用户

 */
//轻松秒杀
class CQueue {

    Deque<Integer> stack1;
    Deque<Integer> stack2;
    public CQueue() {
        stack1=new ArrayDeque();
        stack2=new ArrayDeque();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (!stack2.isEmpty()){
            return stack2.pop();
        }
        if (stack1.isEmpty()){
            return -1;
        }
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}