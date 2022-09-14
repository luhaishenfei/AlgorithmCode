package LC.finished._ListNode.LC641MyCircularDeque.DLinkListNode;

class DLinkListNode {

    int val;
    DLinkListNode next,pre;

    public DLinkListNode() {
    }

    public DLinkListNode(int val) {
        this.val = val;
    }

}

public class MyCircularDeque {
    DLinkListNode nodeF, nodeL;
    private final int CAPACITY;
    private int count;

    public MyCircularDeque(int k) {
        CAPACITY = k;
        count = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        } else if (isEmpty()) {
            nodeL = new DLinkListNode(value);
            nodeF = nodeL;
            count++;
        } else {
            DLinkListNode nodeTmp = new DLinkListNode(value);
            nodeTmp.next = nodeF;
            nodeF.pre=nodeTmp;
            nodeF = nodeTmp;
            count++;
        }
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        } else if (isEmpty()) {
            nodeL = new DLinkListNode(value);
            nodeF = nodeL;
            count++;
        } else {
            DLinkListNode nodeTmp = new DLinkListNode(value);
            nodeTmp.pre=nodeL;
            nodeL.next = nodeTmp;
            nodeL = nodeL.next;
            count++;
        }
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        } else {
            nodeF=nodeF.next;
            count--;
            return true;
        }
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        } else {
            nodeL=nodeL.pre;
            count--;
            return true;
        }
    }

    public int getFront() {
        return isEmpty()?-1:nodeF.val;
    }

    public int getRear() {
        return isEmpty()?-1:nodeL.val;
    }

    public boolean isEmpty() {
        return count==0?true:false;
    }

    public boolean isFull() {
        return count==CAPACITY?true:false;
    }


}

