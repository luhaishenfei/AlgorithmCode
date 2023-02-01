package LC.finished;

import LC.finished._ListNode.ListNode;

//输入：list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
//输出：[0,1,2,1000000,1000001,1000002,5]

// 3 <= list1.length <= 10⁴
// 1 <= a <= b < list1.length - 1
// 1 <= list2.length <= 10⁴

public class LC1669mergeInBetween {
    public static void main(String[] args) {
        LC1669mergeInBetween l = new LC1669mergeInBetween();
        ListNode n1 = new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))));
        ListNode n2 = new ListNode(1000000, new ListNode(1000001, new ListNode(1000002)));
        l.mergeInBetween(n1, 3, 4, n2);
    }

    /*
	执行耗时:1 ms,击败了100.00% 的Java用户
	内存消耗:45.1 MB,击败了10.45% 的Java用户
     */
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        ListNode head = list1;
        ListNode node = list1;

        for (int i = 1; i < a; i++) {
            node = node.next;
        }
        ListNode tmpN = node.next;
        node.next = list2;
        while (node.next != null) {
            node = node.next;
        }
        for (int i = a; i <= b; i++) {
            tmpN = tmpN.next;
        }
        node.next = tmpN;

        return head;
    }

    public ListNode mergeInBetweenRewrite(ListNode list1, int a, int b, ListNode list2) {

        ListNode preNode = list1;
        for (int i = 1; i < a; i++) {
            preNode = preNode.next;
        }

        ListNode bakNode = preNode.next;

        preNode.next = list2;
        while (preNode.next != null) {
            preNode = preNode.next;
        }

        for (int i = a; i <= b; i++) {
            bakNode = bakNode.next;
        }
        preNode.next = bakNode;

        return list1;
    }

    /*
    执行耗时:1 ms,击败了100.00% 的Java用户
	内存消耗:44.7 MB,击败了62.90% 的Java用户
     */
    public ListNode mergeInBetweenLC(ListNode list1, int a, int b, ListNode list2) {
        ListNode preA = list1;
        for (int i = 0; i < a - 1; i++) {
            preA = preA.next;
        }

        ListNode preB = preA;
        for (int i = 0; i < b - a + 2; i++) {
            preB = preB.next;
        }

        preA.next = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }

        list2.next = preB;
        return list1;
    }

}
