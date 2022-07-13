package LC._ListNode;

public class LC203removeElements {
    //     Definition for singly-linked list.


//[1,2,6,3,4,5,6]

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1, new ListNode(
                2, new ListNode(
                6, new ListNode(
                3, new ListNode(
                4, new ListNode(
                5, new ListNode(
                6)
        )
        )
        ))));
        LC203removeElements l = new LC203removeElements();
        l.removeElementsLC(n1,6);
//        l.removeElements(null, 5);
    }
//x
    public ListNode removeElements(ListNode head, int val) {

        if (head == null) return null;

        if (head.val == val) {
            if (head.next == null) {
                head = null;
            } else {
                head = head.next;
            }
        }
        removeElements(head.next, val);
        return head;
    }

    public ListNode removeElementsLC(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        head.next = removeElementsLC(head.next, val);
        return head.val == val ? head.next : head;
    }

//迭代
    public ListNode removeElementsLCDD(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return dummyHead.next;
    }

}
