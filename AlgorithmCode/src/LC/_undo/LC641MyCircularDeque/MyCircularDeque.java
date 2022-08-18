package LC._undo.LC641MyCircularDeque;

import java.util.Arrays;

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

    private boolean isAbsEquals1(int f, int b) {
        if (f < b) {
            return f == 0 && b == q.length - 1?true:false;

        }
        return false;
    }

    public boolean isFull() {
        return isFull;
    }

    public boolean isEmpty() {
        return !isFull;
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
        idxOut = subIdx(idxOut);
        if (idxF == idxOut) isFull = true;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        q[idxF] = value;
        idxF = addIdx(idxF);
        if (idxF == idxOut) isFull = true;
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
        return isEmpty() ? -1 : q[idxOut];
    }

    public int getRear() {
        return isEmpty() ? -1 :
                q[idxF - 1 < 0 ? q.length - 1 : idxF - 1];
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
