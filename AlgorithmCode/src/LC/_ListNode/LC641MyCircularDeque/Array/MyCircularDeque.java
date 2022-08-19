package LC._ListNode.LC641MyCircularDeque.Array;

import java.util.Arrays;

/*
执行结果：
通过
显示详情
添加备注

执行用时：
4 ms
, 在所有 Java 提交中击败了
100.00%
的用户
内存消耗：
42.1 MB
, 在所有 Java 提交中击败了
41.86%
的用户
通过测试用例：
51 / 51
 */
public class MyCircularDeque {


    private int[] q;
    private int idxF;
    private int idxOut;
    private boolean isFull;


    public MyCircularDeque(int k) {
        q = new int[k];
        idxF = 0;
        idxOut = k - 1;
        isFull = false;
    }

    public boolean isFull() {
        return isFull;
    }

    public boolean isEmpty() {
        int dif = idxF - idxOut;
        if (dif == 1 || dif == -q.length + 1) {
            return isFull ? false : true;
        } else {
            return false;
        }
    }


    private int addIdx(int idx) {
        if (idx == q.length - 1) {
            return 0;
        } else {
            return idx + 1;
        }
    }

    private int subIdx(int idx) {
        if (idx == 0) {
            return q.length - 1;
        } else {
            return idx - 1;
        }
    }


    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        q[idxOut] = value;
        if (idxF == idxOut) isFull = true;
        idxOut = subIdx(idxOut);
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        q[idxF] = value;
        if (idxF == idxOut) isFull = true;
        idxF = addIdx(idxF);
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        idxOut = addIdx(idxOut);
        isFull = false;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        idxF = subIdx(idxF);
        isFull = false;
        return true;
    }

    public int getFront() {
        return isEmpty() ?
                -1 :
                q[(idxOut + 1 + q.length) % q.length];
    }

    public int getRear() {
        return isEmpty() ?
                -1 :
                q[(idxF - 1 +q.length )%q.length];
    }


    @Override
    public String toString() {
        return "===================\n" +
                "MyCircularDeque{" +
                ",isEmpty=" + isEmpty() +
                ",\nisFull=" + isFull() +
                ",\nvalues=" + Arrays.toString(q) +
                ",\ngetFront=" + getFront() +
                ",\ngetRear=" + getRear() +
                '}' +
                "\n===================\n";
    }
}
