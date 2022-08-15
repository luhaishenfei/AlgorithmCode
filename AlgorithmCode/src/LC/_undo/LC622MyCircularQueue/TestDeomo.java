package LC._undo.LC622MyCircularQueue;

//import LC._undo.LC622MyCircularQueue.Array.MyCircularQueue;

import LC._undo.LC622MyCircularQueue.Queue.MyCircularQueue;

public class TestDeomo {
    public static void main(String[] args) {
        MyCircularQueue mq = new MyCircularQueue(6);


//["MyCircularQueue","enQueue","Rear","Rear","deQueue","enQueue","Rear","deQueue","Front","deQueue","deQueue","deQueue"]
//[[6],[6],[],[],[],[5],[],[],[],[],[],[]]
//        输出：
//[null,true,0,0,true,true,6,true,-1,false,false,false]
//        预期结果：
//[null,true,6,6,true,true,5,true,-1,false,false,false]
        System.out.println(mq.enQueue(6));
        System.out.println(mq.Rear());
        System.out.println(mq.Rear());

        System.out.println(mq.deQueue());
        System.out.println(mq.enQueue(5));
        System.out.println(mq.Rear());
        System.out.println(mq.deQueue());
        System.out.println(mq.Front());
        System.out.println(mq.deQueue());
        System.out.println(mq.deQueue());
        System.out.println(mq.deQueue());

    }

}
