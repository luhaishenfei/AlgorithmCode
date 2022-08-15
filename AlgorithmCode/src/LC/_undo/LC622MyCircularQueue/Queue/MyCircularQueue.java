package LC._undo.LC622MyCircularQueue.Queue;

class ListNode {

    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
public class MyCircularQueue {
    private ListNode head;
    private ListNode tail;
    private int limit;
    private int count;

    public MyCircularQueue(int k) {
        limit = k;
        count = 0;
    }

    public boolean enQueue(int value) {
        if (count == limit) {
            return false;
        }
        if (head == null) {
            head = new ListNode(value);
            tail = head;
        } else {
            tail.next = new ListNode(value);
            tail = tail.next;
        }
        count++;
        return true;
    }

    public boolean deQueue() {
        if (count == 0) {
            return false;
        }
        head = head.next;
        count--;
        return true;
    }

    public int Front() {
        if (count == 0) {
            return -1;
        } else {
            return head.val;

        }
    }

    public int Rear() {
        if (count == 0) {
            return -1;
        } else {
            return tail.val;
        }
    }

    public boolean isEmpty() {
        return count == 0 ? true : false;
    }

    public boolean isFull() {
        return count == limit ? true : false;
    }
}
