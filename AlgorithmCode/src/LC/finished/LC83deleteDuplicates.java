package LC.finished;


import LC.finished._ListNode.ListNode;

public class LC83deleteDuplicates {

    public static void main(String[] args) {
        LC83deleteDuplicates l = new LC83deleteDuplicates();
        ListNode n1 = new ListNode(6, new ListNode(
                6, new ListNode(
                6, new ListNode(
                6, new ListNode(
                6, new ListNode(
                6, new ListNode(
                6, new ListNode(
                6)
        )))))));
        l.deleteDuplicates(n1);
    }

    //dg
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        if (head.next == null) return head;
        head.next = deleteDuplicates(head.next);

        if (head.val == head.next.val) {
            head = head.next;
        }
        return head;

    }
    public ListNode deleteDuplicateslc1(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        head.next = deleteDuplicates(head.next);
        if(head.val == head.next.val) head = head.next;
        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
//            Forguncy.Page.getListView('表格1').getQuery('E13')
            ListNode preN=null;
            ListNode curr=head;
            while (curr!=null){
                if (preN.val==curr.val){
                    preN=curr;
                    curr=preN.next;
                }else {
                    ListNode tmp=curr.next;
//                    preN=
                }


            }
        return null;

        }






        public ListNode removeElementsLC(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        head.next = removeElementsLC(head.next, val);
        return head.val == val ? head.next : head;
    }

    public ListNode deleteDuplicatesLC2(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }

}
