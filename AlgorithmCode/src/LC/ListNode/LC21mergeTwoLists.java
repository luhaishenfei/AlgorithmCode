package LC.ListNode;

public class LC21mergeTwoLists {


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1==null) return list2;
        if (list2==null) return list1;
        ListNode tmp;
        if (list1.val<list2.val){
            tmp=list1;
            list1=list1.next;

        }else {
            tmp=list2;
            list2=list2.next;
        }


        while (list1.next==null){
            while (list2.next==null){
                 if (list1.val<list2.val){
                     tmp.next=list1;


                 }else {


                 }
            }
        }

        return null;
    }

    //递归
    public ListNode mergeTwoListsLC2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoListsLC(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

}
