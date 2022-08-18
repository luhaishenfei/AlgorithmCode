package LC._undo.LC641MyCircularDeque;

public class TestDemo {
    public static void main(String[] args) {
        MyCircularDeque myDeque= new MyCircularDeque(3);

        System.out.println(myDeque.toString());
        System.out.println(myDeque.insertFront(1));
        System.out.println(myDeque.toString());
        System.out.println(myDeque.insertFront(2));
        System.out.println(myDeque.toString());

        System.out.println(myDeque.insertLast(-1));
        System.out.println(myDeque.toString());
        System.out.println(myDeque.insertLast(-2));
        System.out.println(myDeque.toString());
        System.out.println(myDeque.deleteFront());
        System.out.println(myDeque.toString());
        System.out.println(myDeque.deleteFront());
        System.out.println(myDeque.toString());
        System.out.println(myDeque.deleteFront());
        System.out.println(myDeque.toString());
        System.out.println(myDeque.deleteLast());
        System.out.println(myDeque.toString());

    }
}
