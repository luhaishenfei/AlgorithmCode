package LC._undo;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC946validateStackSequences {


    //输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
    public boolean validateStackSequences(int[] pushed, int[] popped) {


        int idxPush = 0;
        int idxPop = 0;
        Deque<Integer> stack = new ArrayDeque();

        while (idxPush==pushed.length||idxPop==popped.length) {
            int vPush=pushed[idxPush];
            int vPop =popped[idxPop];
            if (vPush == vPop) {
                idxPush++;
                idxPop++;
            } else if (stack.peek() != vPop) {
                stack.push(vPush);
                idxPush++;
            }else {
                stack.pop();
                idxPop++;
            }
        }
        if (idxPop==popped.length&&idxPush==pushed.length){
            return true;
        }
        return false;
    }
}
