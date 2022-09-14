package LC.finished._ListNode;

/*
2. 两数相加
给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。

请你将两个数相加，并以相同形式返回一个表示和的链表。

你可以假设除了数字 0 之外，这两个数都不会以 0 开头。



示例 1：


输入：l1 = [2,4,3], l2 = [5,6,4]
输出：[7,0,8]
解释：342 + 465 = 807.
示例 2：

输入：l1 = [0], l2 = [0]
输出：[0]
示例 3：

输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
输出：[8,9,9,9,0,0,0,1]


提示：

每个链表中的节点数在范围 [1, 100] 内
0 <= Node.val <= 9
题目数据保证列表表示的数字不含前导零
通过次数1,418,847提交次数3,381,819
 */
public class LC2addTwoNumbers {

    /*
输入：l1 = [2,4,3], l2 = [5,6,4]
输出：[7,0,8]
解释：342 + 465 = 807.
     */
    /*
    输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
    输出：[8,9,9,9,0,0,0,1]
     */

    /*
    执行用时：
1 ms
, 在所有 Java 提交中击败了
100.00%
的用户
内存消耗：
41.4 MB
, 在所有 Java 提交中击败了
60.47%
的用户
通过测试用例：
1568 / 1568
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tmp = new ListNode();
        ListNode res = tmp;
        boolean biggerThanTen=false;
        while (l1 != null || l2 != null) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            num1 = num1 + num2+(biggerThanTen?1:0);
            //进位
            biggerThanTen = num1 >= 10 ? true : false;
            tmp.next = new ListNode(num1 % 10);
            tmp = tmp.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (biggerThanTen){
            tmp.next=new ListNode(1);
        }
        return res.next;
    }


    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode tmp = new ListNode();
        ListNode res = tmp;
        int curry=0;
        while (l1 != null || l2 != null) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            num1 = num1 + num2+curry;
            //进位
            curry = num1 / 10;
            tmp.next = new ListNode(num1 % 10);
            tmp = tmp.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (curry>0){
            tmp.next=new ListNode(curry);
        }
        return res.next;
    }

    /*
    shortest code
     */
    public ListNode addTwoNumbersLCUser(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1), pre = dummyHead;
        int t = 0;
        while (l1 != null || l2 != null || t != 0) {
            if (l1 != null) {
                t += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                t += l2.val;
                l2 = l2.next;
            }
            pre.next = new ListNode(t % 10);
            pre = pre.next;
            t /= 10;
        }
        return dummyHead.next;
    }
}
