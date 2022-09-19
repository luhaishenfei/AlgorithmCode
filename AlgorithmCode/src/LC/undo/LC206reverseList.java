package LC.undo;

import LC.finished._ListNode.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC206reverseList {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2, n1);
        ListNode n3 = new ListNode(3, n2);
        ListNode n4 = new ListNode(4, n3);
        ListNode n5 = new ListNode(5, n4);
        LC206reverseList l = new LC206reverseList();
        l.reverseList1(n5);

    }

    //stack
    public ListNode reverseList1(ListNode head) {
        if (head == null) return head;
        Deque<ListNode> stack = new ArrayDeque();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode res = new ListNode();
        ListNode tmpH = res;
        while (!stack.isEmpty()) {
            res.next = stack.pop();
            res = res.next;
        }
        res.next = null;
        return tmpH.next;
    }

//    public ListNode reverseList(ListNode head) {
//        if (head == null) return head;
//        ListNode tailNode=head;
//        ListNode tmpNode;
//        while (head.next != null) {
////            tmpNode = end.next;
//            tmpNode = tailNode.next;
//            tailNode.next=tmpNode.next;
//            tmpNode.next=head;
//            head=tmpNode;
//
//        }
//
//
//        ListNode tmpNode;
//        while (head.next != null) {
//            tmpNode = head.next;
//
//
//        }
//
//
//        return null;
//    }

    //LC迭代
    public ListNode reverseListDD(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }


    //LC递归
    public ListNode reverseListDG(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseListDG(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
