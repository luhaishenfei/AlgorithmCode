package LC._ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
23. 合并K个升序链表
给你一个链表数组，每个链表都已经按升序排列。

请你将所有链表合并到一个升序链表中，返回合并后的链表。



示例 1：

输入：lists = [[1,4,5],[1,3,4],[2,6]]
输出：[1,1,2,3,4,4,5,6]
解释：链表数组如下：
[
  1->4->5,
  1->3->4,
  2->6
]
将它们合并到一个有序链表中得到。
1->1->2->3->4->4->5->6
示例 2：

输入：lists = []
输出：[]
示例 3：

输入：lists = [[]]
输出：[]


提示：

k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-10^4 <= lists[i][j] <= 10^4
lists[i] 按 升序 排列
lists[i].length 的总和不超过 10^4
 */
public class LC23mergeKLists {
    //    lists = [[1,4,5],[1,3,4],[2,6]]
//    [1,1,2,3,4,4,5,6]
    public static void main(String[] args) {
        ListNode n1 = new ListNode(-2, new ListNode(
                -1, new ListNode(
                -1, new ListNode(
                -1
        )
        )));
        ListNode n2 = new ListNode(1, new ListNode(
                3, new ListNode(
                6
        )));
        ListNode n3 = new ListNode(2, new ListNode(
                6
        ));

        n2.next=n3;
        n3.val=n1.val;
        n3.next=n1.next;


        ListNode[] lists = {n1, null};
        LC23mergeKLists l = new LC23mergeKLists();

        n2= l.insertListNode(n2,new ListNode(4));


        l.mergeKLists(lists);
    }



    public ListNode insertListNode(ListNode node,ListNode insertNode){
        if (insertNode==null) return node;
        if (node==null){
            node=insertNode;
            node.next=null;
            return node;
        }
        ListNode res = node;
        while (res!=null){
            if (res.val>insertNode.val){
                insertNode.next=res;
                res=insertNode;
                return node;
            }
            res=res.next;
        }
            res.next=insertNode;
            insertNode.next=null;
            return node;

    }





    //自己实现的优先队列 与LC的最后都要遍历下queue，直接实现个ListNode的优先队列插入，会不会快点？
    /*
    执行用时：
5 ms
, 在所有 Java 提交中击败了
37.33%
的用户
内存消耗：
43.1 MB
, 在所有 Java 提交中击败了
78.65%
的用户
通过测试用例：
133 / 133
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>((o1, o2) -> o1.val - o2.val);
        for (int i = 0; i < lists.length; i++) {
            while (lists[i] != null) {
                queue.offer(lists[i]);
                lists[i] = lists[i].next;
            }
        }
        ListNode tmp = queue.poll();
        ListNode res = tmp;
        while (!queue.isEmpty()) {
            tmp.next = queue.poll();
            tmp = tmp.next;
        }
        if (tmp != null) {
            tmp.next = null;
        }
        return res;
    }


    //LC的优先队列 其实也还好
    /*
    执行用时：
4 ms
, 在所有 Java 提交中击败了
70.57%
的用户
内存消耗：
43.5 MB
, 在所有 Java 提交中击败了
24.45%
的用户
通过测试用例：
133 / 133
     */
    public ListNode mergeKListsLC(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val) return -1;
                else if (o1.val == o2.val) return 0;
                else return 1;
            }
        });
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        for (ListNode node : lists) {
            if (node != null) queue.add(node);
        }
        while (!queue.isEmpty()) {
            p.next = queue.poll();
            p = p.next;
            if (p.next != null) queue.add(p.next);
        }
        return dummy.next;
    }


    private boolean isAllEmpty(ListNode[] lists) {
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) return false;
        }
        return true;
    }

    /*
    //自己写的这个算法，速度慢是因为:
    假设数组元素个数是3，则要先循环一次(检索3次)，找出最小元素，然后添加到返回，
    然后又开始循环，还是检索3次，此时只有一个元素未被检索过，造成了浪费，所以可能用优先队列好些
    执行用时：
220 ms
, 在所有 Java 提交中击败了
5.08%
的用户
内存消耗：
43.3 MB
, 在所有 Java 提交中击败了
49.60%
的用户
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists.length == 0) return null;
        ListNode miniNode = new ListNode(Integer.MAX_VALUE);
        ListNode res = miniNode;
        while (!isAllEmpty(lists)) {
            int miniIdx = 0;
            ListNode tmpNode = new ListNode(Integer.MAX_VALUE);
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    if (lists[i].val < tmpNode.val) {
                        miniIdx = i;
                        tmpNode = lists[i];
                    }
                }
            }
            miniNode.next = tmpNode;
            miniNode = miniNode.next;
            lists[miniIdx] = lists[miniIdx].next;
        }
        return res.next;
    }


}
