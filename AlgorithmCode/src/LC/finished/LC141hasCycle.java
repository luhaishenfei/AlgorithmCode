package LC.finished;

import LC.finished._ListNode.ListNode;

public class LC141hasCycle {



    public boolean hasCycle(ListNode head) {
        ListNode tmpNode = head.next;

        while (true) {
            if (tmpNode == head) {
                //循环了
                return false;
            }
            if (tmpNode == null) {
                return true;
            }
            ListNode t = tmpNode.next;
            tmpNode.next = head;
            tmpNode = t;
        }
    }

    //快慢指针
    public boolean hasCycleLC(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
