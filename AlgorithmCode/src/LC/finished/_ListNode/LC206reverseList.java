package LC.finished._ListNode;

public class LC206reverseList {

    public static void main(String[] args) {
        LC206reverseList l = new LC206reverseList();
        l.reverseList(new ListNode(1, new ListNode(
                2, new ListNode(
                        3, new ListNode(
                                4)))));


    }

    //ok
    /*
    执行用时：
0 ms
, 在所有 Java 提交中击败了
100.00%
的用户
内存消耗：
40.8 MB
, 在所有 Java 提交中击败了
95.73%
的用户
通过测试用例：
28 / 28
     */
    public ListNode reverseList(ListNode head) {
        ListNode preN = null;
        ListNode currN = head;
        while (currN != null) {
            ListNode next = currN.next;
            currN.next = preN;
            preN = currN;
            currN = next;
        }
        return preN;
    }


    public ListNode reverseListLC(ListNode head) {
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

}
