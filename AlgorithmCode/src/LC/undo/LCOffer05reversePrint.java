package LC.undo;

import LC.finished._ListNode.ListNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LCOffer05reversePrint {
    public static void main(String[] args) {

    }



    int[] res;
    int i = 0;
    int j = 0;
    public int[] reversePrintLC(ListNode head) {
        solve(head);
        return res;
    }
    public void solve(ListNode head){
        if(head == null){
            res = new int[i];
            return;
        }
        i++;
        solve(head.next);
        res[j] = head.val;
        j++;
    }

    /*
    > 2022/11/14 14:35:47
解答成功:
	执行耗时:1 ms,击败了68.09% 的Java用户
	内存消耗:42.2 MB,击败了26.69% 的Java用户
     */
    public int[] reversePrint(ListNode head) {
        Deque<Integer> stack = new LinkedList();
        while (head!=null){
            stack.push(head.val);
            head=head.next;
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i]=stack.pop();
        }
        return res;
    }
}
